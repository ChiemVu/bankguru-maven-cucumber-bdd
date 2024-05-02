package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends CommonPageObject {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToEmailTextbox(String email) {
        waitForElementClickable(RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(RegisterPageUI.SUBMIT_BUTTON);
        clickToElement(RegisterPageUI.SUBMIT_BUTTON);
    }

    public String getUserIDText() {
        waitForElementVisible(RegisterPageUI.USER_ID_TEXT);
        waitForElementClickable(RegisterPageUI.USER_ID_TEXT);
        return getElementText(RegisterPageUI.USER_ID_TEXT);
    }

    public String getPasswordText() {
        waitForElementVisible(RegisterPageUI.PASSWORD_TEXT);
        return getElementText(RegisterPageUI.PASSWORD_TEXT);
    }

    public LoginPageObject openLoginPage(String loginPageUrl) {
        openPageUrl(loginPageUrl);
        return PageGeneratorManager.getLoginPage(driver);
    }
}
