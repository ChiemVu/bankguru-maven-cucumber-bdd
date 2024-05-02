package pageObjects;

import org.openqa.selenium.WebDriver;

public class ManagerPageObject extends CommonPageObject {
    private WebDriver driver;
    public ManagerPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
