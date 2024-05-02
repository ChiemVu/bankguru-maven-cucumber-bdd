package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.NewAccountPageUI;

public class NewAccountPageObject extends CommonPageObject {
    private WebDriver driver;
    public NewAccountPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void selectToAccountTypeDefaultDropdownByName(String dropdownText) {
        waitForElementClickable(NewAccountPageUI.ACCOUNT_TYPE_DEFAULT_DROPDOWN);
        selectItemInDefaultDropdown(NewAccountPageUI.ACCOUNT_TYPE_DEFAULT_DROPDOWN, dropdownText);
    }
    public void enterToInitialDepositTextbox(String keyToSend) {
        waitForElementClickable(NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
        clickToElement(NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
        sendKeyToElement(NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, keyToSend);
    }
}
