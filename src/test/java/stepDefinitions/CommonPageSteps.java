package stepDefinitions;

import cucumberOptions.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.CommonPageObject;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import utilities.DataFakerConfig;

public class CommonPageSteps {
    WebDriver driver;
    CommonPageObject commonPage;
    DataFakerConfig dataFaker;
    static String email;

    public CommonPageSteps() {
        driver = Hooks.openAndQuitBrowser();
        commonPage = PageGeneratorManager.getCommonPage(driver);
        dataFaker = DataFakerConfig.getDataFakerConfig();
        email = dataFaker.getEmail();
    }
    @Given("Open {string} page")
    public void openPage(String managerMenuName) {
        commonPage.openPageAtManageMenuLinkByName(managerMenuName);
    }

    @When("Input  to {string} textbox with value {string}")
    public void inputToTextboxWithValue(String fieldName, String inputValue) {
        if (fieldName.equals("E-mail")){
            inputValue = email;
        }
        commonPage.inputToDynamicTextboxByLabelName(inputValue, fieldName);
    }

    @When("Input  to {string} textarea with value {string}")
    public void inputToTextareaWithValue(String fieldName, String inputValue) {
        commonPage.inputToAddressTextarea(inputValue, fieldName);
    }
    @When("Click to {string} button")
    public void clickToButton(String buttonValue) {
        commonPage.clickToButtonByAttributeValue(buttonValue);
    }
    @Then("Success message displayed with {string}")
    public void successMessageDisplayedWith(String expectedMessage) {
       Assert.assertTrue(commonPage.isDynamicMessageDisplayed(expectedMessage));
    }
}
