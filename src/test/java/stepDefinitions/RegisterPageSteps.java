package stepDefinitions;

import cucumberOptions.Hooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import utilities.DataFakerConfig;

public class RegisterPageSteps {
    private WebDriver driver;
    static String username, password;
    RegisterPageObject registerPage;
    DataFakerConfig dataTest;

    public RegisterPageSteps() {
        driver = Hooks.openAndQuitBrowser();
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        dataTest = DataFakerConfig.getDataFakerConfig();
    }


    @When("Input to Email textbox")
    public void inputToEmailTextbox() {
        registerPage.inputToEmailTextbox(dataTest.getEmail());
    }

    @When("Click to Submit")
    public void clickToSubmit() {
        registerPage.clickToSubmitButton();
    }

    @Then("Get User and Password infor")
    public void getUserAndPasswordInfor() {
        username = registerPage.getUserIDText();
        password = registerPage.getPasswordText();
        System.out.println("Username va Password la: " + username + "va " + password);
    }

    @When("Back to Login page")
    public void backToLoginPage() {
        registerPage.openLoginPage(LoginPageSteps.loginPageUrl);
    }



}
