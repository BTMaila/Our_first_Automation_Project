package stepDefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("I open the login page")
    public void openLoginPage() {
        driver = DriverFactory.initDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }

    @When("I enter {string} and {string}")
    public void enterCredentials(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("I should land on the account page")
    public void verifyLoginSuccess() {
        String header = loginPage.getHeader();
        Assert.assertTrue("Expected 'My Account' in page header but got: " + header,
                header.contains("My Account"));
        DriverFactory.quitDriver();
    }

    @Then("I should see {string}")
    public void iShouldSee(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getWarningMessage();
        Assert.assertEquals("Error message mismatch", expectedErrorMessage, actualErrorMessage);
        DriverFactory.quitDriver();
    }
}
