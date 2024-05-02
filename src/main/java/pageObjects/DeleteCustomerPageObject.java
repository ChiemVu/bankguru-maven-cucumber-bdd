package pageObjects;

import org.openqa.selenium.WebDriver;

public class DeleteCustomerPageObject extends CommonPageObject {
    private WebDriver driver;
    public DeleteCustomerPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void acceptToDeleteAlert() {
        acceptToAlert();
        sleepInSecond(3);
    }

    public String getTextAtDeleteAlert() {
        sleepInSecond(3);
        return getTextInAlert();

    }
}
