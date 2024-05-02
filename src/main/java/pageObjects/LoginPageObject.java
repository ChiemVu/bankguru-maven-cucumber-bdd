package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends CommonPageObject {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public String getLoginPageUrl(){
        return getCurrentPageUrl();
    }

    public RegisterPageObject clickToHereLink(){
        waitForElementClickable(LoginPageUI.HERE_LINK);
        clickToElement(LoginPageUI.HERE_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }
    public void enterToUserIDTextbox(String userID) {
        waitForElementVisible(LoginPageUI.USER_ID_TEXTBOX);
        sendKeyToElement(LoginPageUI.USER_ID_TEXTBOX, userID);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public ManagerPageObject clickToLoginButton() {
        waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
        clickToElement(LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getManagerPage(driver);
    }
}
