package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static ManagerPageObject getManagerPage(WebDriver driver){
        return new ManagerPageObject(driver);
    }

    public static NewCustomerPageObject getNewCustomerPage(WebDriver driver){
        return  new NewCustomerPageObject(driver);
    }
    public static EditCustomerPageObject getEditCustomerPage(WebDriver driver){
        return new EditCustomerPageObject(driver);
    }
    public static DeleteCustomerPageObject getDeleteCustomerPage(WebDriver driver){
        return new DeleteCustomerPageObject(driver);
    }
    public static NewAccountPageObject getNewAccountPage(WebDriver driver){
        return new NewAccountPageObject(driver);
    }
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }
    public static CommonPageObject getCommonPage(WebDriver driver){
        return new CommonPageObject(driver);
    }
}
