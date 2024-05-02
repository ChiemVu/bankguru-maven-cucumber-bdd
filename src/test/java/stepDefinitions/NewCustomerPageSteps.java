package stepDefinitions;

import cucumberOptions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageGeneratorManager;

public class NewCustomerPageSteps {
    WebDriver driver;
    NewCustomerPageObject newCustomerPage;
    public NewCustomerPageSteps(){
        driver = Hooks.openAndQuitBrowser();
        newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
    }
    @When("Click to {string} radio button")
    public void clickToRadioButton(String radioButtonValue) {
        newCustomerPage.clickToRadioByAttributeValue(radioButtonValue);
    }

    @Then("The valid text displayed at {string} with value{string}")
    public void theValidTextDisplayedAtWithValue(String rowName, String expectedValue) {
        if (rowName.equals("Email")){
            expectedValue = CommonPageSteps.email;
        }
        Assert.assertEquals( newCustomerPage.getCustomerInfoByRowName(rowName), expectedValue);
    }
}
