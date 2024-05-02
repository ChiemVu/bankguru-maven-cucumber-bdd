package pageObjects;

import dataObjects.CustomerInfo;
import org.openqa.selenium.WebDriver;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends CommonPageObject {
    private WebDriver driver;

    public NewCustomerPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickToRadioByAttributeValue(String attributeValue) {
        waitForElementClickable(NewCustomerPageUI.DYNAMIC_RADIO_BUTTON_BY_ATTRIBUTE_VALUE, attributeValue);
        checkToElement(NewCustomerPageUI.DYNAMIC_RADIO_BUTTON_BY_ATTRIBUTE_VALUE, attributeValue);
        sleepInSecond(3);
    }
    public void setNewCustomerInfor(CustomerInfo customerInfor) {
        inputToDynamicTextboxByLabelName(customerInfor.getCustomerName(), "Customer Name");
        clickToRadioByAttributeValue(String.valueOf(customerInfor.getGender().charAt(0)));
        inputToDynamicTextboxByLabelName(customerInfor.getDateOfBirth(), "Date of Birth");
        inputToAddressTextarea(customerInfor.getAddress(), "Address");
        inputToDynamicTextboxByLabelName(customerInfor.getCity(), "City");
        inputToDynamicTextboxByLabelName(customerInfor.getState(), "State");
        inputToDynamicTextboxByLabelName(customerInfor.getPin(), "PIN");
        inputToDynamicTextboxByLabelName(customerInfor.getMobileNumber(), "Mobile Number");
        inputToDynamicTextboxByLabelName(customerInfor.getEmail(), "E-mail");
        inputToDynamicTextboxByLabelName(customerInfor.getPassword(), "Password");
    }
    public String getCustomerInfoByRowName(String rowName) {
        waitForElementVisible(NewCustomerPageUI.DYNAMIC_CUSTOMER_INFO_BY_ROW_NAME, rowName);
        return getElementText(NewCustomerPageUI.DYNAMIC_CUSTOMER_INFO_BY_ROW_NAME, rowName);
    }
}
