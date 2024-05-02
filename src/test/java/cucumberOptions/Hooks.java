package cucumberOptions;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import io.cucumber.java.Before;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import commons.GlobalConstants;
import utilities.Environment;


public class Hooks {
    // Driver la static la Run for many thread
    private static WebDriver driver;
    private static Environment environment;
    private static final Logger log = LogManager.getLogger(Hooks.class.getName());

    @Before // synchronized = handle đồng bộ, method openAndQuitBrowser để cho các class khác có thể gọi qua mà k cần khởi tạo hooks này lên
    public synchronized static WebDriver openAndQuitBrowser() {
        // Run by Maven command line: mvn clean test -DBROWSER=
        String browser = System.getProperty("BROWSER");
        String environmentName = System.getProperty("envi");
        ConfigFactory.setProperty("env", environmentName);
        environment = ConfigFactory.create(Environment.class);
        System.out.println("Browser name run by command line = " + browser);

        // Check driver đã được khởi tạo hay chưa?
        if (driver == null) {

            // Happy path case
            try {
                // Kiem tra BROWSER = null -> gan = chrome/ firefox (browser default for project)
                if (browser == null) {
                    // Get browser name from Environment Variable in OS
                    browser = System.getenv("BROWSER");
                    System.out.println("Get Browser name from OS environment = " + browser);
                    if (browser == null) {
                        // Set default browser
                        browser = "firefox";
                    }
                }

                switch (browser) {
                    case "chrome":
                        driver = new ChromeDriver();
                        break;
                    case "hchrome":
                        ChromeOptions chOption = new ChromeOptions();
                        chOption.addArguments("--headless");
                        chOption.addArguments("window-size=1920x1080");
                        driver = new ChromeDriver(chOption);
                        break;
                    case "hfirefox":
                        FirefoxOptions ffHeadlessOption = new FirefoxOptions();
                        ffHeadlessOption.addArguments("--headless");
                        ffHeadlessOption.addArguments("window-size=1920x1080");
                        driver = new FirefoxDriver(ffHeadlessOption);
                        break;
                    case "ie":
                        driver = new InternetExplorerDriver();
                        break;
                    default:
                        driver = new FirefoxDriver();
                        break;
                }
            }
            // Code này luôn luôn được chạy dù pass hay fail
            finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }

            driver.manage().window().maximize();
            driver.get(environment.appUserUrl());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.getGlobalConstant().getLongTime()));
            log.info("------------- Started the browser -------------");
        }
        return driver;
    }

    public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
                log.info("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Can not close the browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

}