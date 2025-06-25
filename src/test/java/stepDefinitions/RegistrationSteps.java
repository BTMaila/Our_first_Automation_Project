package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class RegistrationSteps {
    WebDriver driver;
    RegistrationPage regPage;

    @Given("User is on the registration page")
    public void navigateToRegistrationPage() {
        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register"); // Change to actual URL
        regPage = new RegistrationPage(driver);
    }

    @When("User enters valid registration details")
    public void enterValidDetails() {
        regPage.enterFirstName("Eddie");
        regPage.enterLastName("Ngoveni");
        regPage.enterEmail("eddyngoveni@gmail.com");
        regPage.enterPhone("0712345678");
        regPage.enterPassword("Secure@123");
        regPage.enterConfirmPassword("Secure@123");
        regPage.chooseSubscribeNo();
        regPage.acceptPrivacyPolicy();

    }

    @And("User clicks the register button")
    public void clickRegister() {
        regPage.clickRegister();
    }

    @Then("A success message or account page should be displayed")
    public void verifyRegistrationSuccess() {
        assertTrue(driver.getCurrentUrl().contains("account") || driver.getPageSource().contains("Welcome"));
        driver.quit();
    }
}