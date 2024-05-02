package stepDefinitions;

import cucumberOptions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import utilities.Environment;

public class LoginPageSteps {

    WebDriver driver;
    static String loginPageUrl;
    LoginPageObject loginPage;
    Environment environment;
    public LoginPageSteps(){
        driver = Hooks.openAndQuitBrowser();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        environment = ConfigFactory.create(Environment.class);
    }

    @Given("Get login page Url")
    public void getLoginPageUrl() {
        loginPageUrl = loginPage.getLoginPageUrl();
    }

    @When("Open Register page")
    public void openRegisterPage() {
        loginPage.clickToHereLink();
    }

    @Given("Submit to login form")
    public void submitToLoginForm() {
        loginPage.enterToUserIDTextbox(environment.appUserID());
        loginPage.enterToPasswordTextbox(environment.appPassword());
        loginPage.clickToLoginButton();
    }

    @And("Submit valid infor to login form")
    public void submitValidInforToLoginForm() {
        loginPage.enterToUserIDTextbox(RegisterPageSteps.username);
        loginPage.enterToPasswordTextbox(RegisterPageSteps.password);
        loginPage.clickToLoginButton();
    }
}
