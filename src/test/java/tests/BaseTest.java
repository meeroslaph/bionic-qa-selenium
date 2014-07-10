package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import selenium.WebDriverFactory;
import utils.Log4Test;
import utils.PropertyLoader;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void intEnv() {
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        driver.manage().window().maximize();
    }

    @BeforeTest
    public void beforeTest() {
        Log4Test.info("*#*#*#*#*#*#*#*#*#* Start of the test. *#*#*#*#*#*#*#*#*#*");
    }

    @AfterTest
    public void afterTest() {
        Log4Test.info("*#*#*#*#*#*#*#*#*#*  End of the test.  *#*#*#*#*#*#*#*#*#*");
    }

    @AfterSuite
    public void shutEnv() {
        if (driver != null) {
            driver.quit();
        }
    }
}