package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import selenium.WebDriverFactory;
import utils.PropertyLoader;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void intEnv() {
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void shutEnv() {
        if (driver != null) {
            driver.quit();
        }
    }
}