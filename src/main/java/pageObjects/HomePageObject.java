package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends CommonPageObject {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isWelcomeMessageDisplayed() {
        waitForElementVisible(HomePageUI.WELCOME_MESSAGE);
        return isElementDisplayed(HomePageUI.WELCOME_MESSAGE);
    }
}
