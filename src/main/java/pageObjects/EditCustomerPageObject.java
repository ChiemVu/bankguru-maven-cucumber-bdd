package pageObjects;

import org.openqa.selenium.WebDriver;

public class EditCustomerPageObject extends CommonPageObject {
    private WebDriver driver;
    public EditCustomerPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

}
