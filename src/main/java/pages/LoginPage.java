package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    private By emailField = By.id("input-email");
    private By passwordField = By.id("input-password");
    private By loginButton = By.cssSelector("input[value='Login']");
    private By loginHeader = By.tagName("h2");
    private By warningMessage = By.cssSelector("div.alert.alert-danger");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getHeader() {
        return driver.findElement(loginHeader).getText().trim();
    }

    public String getWarningMessage() {
        return driver.findElement(warningMessage).getText().trim();
    }
}
