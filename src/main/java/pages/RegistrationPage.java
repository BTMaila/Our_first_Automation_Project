package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By phone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By subscribeNo = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");
    By privacyPolicy = By.name("agree");
    By registerButton = By.xpath("//*[@id='content']/form/div/div/input[@value='Continue']");


    // Actions
    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }
    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }
    public void enterEmail(String emailAddr) {
        driver.findElement(email).sendKeys(emailAddr);
    }
    public void enterPhone(String phoneNum) {
        driver.findElement(phone).sendKeys(phoneNum);
    }
    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }
    public void enterConfirmPassword(String confirmPwd) {
        driver.findElement(confirmPassword).sendKeys(confirmPwd);
    }
    public void chooseSubscribeNo() {
        driver.findElement(subscribeNo).click();
    }
    public void acceptPrivacyPolicy() {
        WebElement checkbox = driver.findElement(privacyPolicy);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }
}

