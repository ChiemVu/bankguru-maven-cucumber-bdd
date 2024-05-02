package pageObjects;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.CommonPageUI;

public class CommonPageObject extends BasePage {
    private WebDriver driver;
    public CommonPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void openPageAtManageMenuLinkByName(String managerMenuName) {
        waitForElementClickable(CommonPageUI.DYNAMIC_MANAGER_MENU, managerMenuName);
        clickToElement(CommonPageUI.DYNAMIC_MANAGER_MENU, managerMenuName);
    }
    public void inputToDynamicTextboxByLabelName(String keyToSend, String textboxLabelName) {
        waitForElementClickable(CommonPageUI.DYNAMIC_TEXTBOX, textboxLabelName);
        if (textboxLabelName.equals("Date of Birth")){
            removeAttributeInDOM(CommonPageUI.DYNAMIC_TEXTBOX, "type", textboxLabelName);
            sleepInSecond(2);
        }
        sendKeyToElement(CommonPageUI.DYNAMIC_TEXTBOX, keyToSend, textboxLabelName);
    }
    public void inputToAddressTextarea(String keyToSend, String textboxLabelName) {
        waitForElementClickable(CommonPageUI.ADDRESS_TEXTAREA, textboxLabelName);
        clickToElement(CommonPageUI.ADDRESS_TEXTAREA, textboxLabelName);
        sendKeyToElement(CommonPageUI.ADDRESS_TEXTAREA, keyToSend, textboxLabelName);
    }
    public boolean isDynamicMessageDisplayed(String messageText) {
        waitForElementVisible(CommonPageUI.DYNAMIC_MESSAGE, messageText);
        return isElementDisplayed(CommonPageUI.DYNAMIC_MESSAGE, messageText);
    }
    public void clickToButtonByAttributeValue(String attributeValue) {
        waitForElementClickable(CommonPageUI.DYNAMIC_BUTTON_BY_ATTRIBUTE_VALUE, attributeValue);
        clickToElement(CommonPageUI.DYNAMIC_BUTTON_BY_ATTRIBUTE_VALUE, attributeValue);
    }
}