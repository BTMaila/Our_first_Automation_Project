package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    public static WebDriver driver;
    public static Properties config = new Properties();

    public static void loadConfig() {
        try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
            config.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static WebDriver initDriver() {
        System.out.println("start initialize");
        loadConfig();

        String browser = config.getProperty("browser", "chrome").toLowerCase();
        String baseUrl = config.getProperty("baseUrl");
        String headless = config.getProperty("headless");

        switch (browser.toLowerCase()) {
            case "chrome":
                System.out.println("Chrome browser selected");
                ChromeOptions options = new ChromeOptions();
                if (headless.equalsIgnoreCase("yes")) {
                    options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
                    System.out.println("running headless");

                }

                driver = new ChromeDriver(options);

                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(baseUrl);

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
