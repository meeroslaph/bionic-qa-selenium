package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HomePage;
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
        Log4Test.info("*#*#*#*#*#*#*#*#*#* Start of the test suite. *#*#*#*#*#*#*#*#*#*");
    }

    @BeforeMethod
    public void beforeMethod() {
        Log4Test.info("*#*#*#*#*#*#*#*#*#* Start of the test. *#*#*#*#*#*#*#*#*#*");
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isOpened();
    }

    @AfterMethod
    public void afterMethod() {
        Log4Test.info("*#*#*#*#*#*#*#*#*#*  End of the test.  *#*#*#*#*#*#*#*#*#*");
    }

    @AfterTest
    public void afterTest() {
        Log4Test.info("*#*#*#*#*#*#*#*#*#*  End of the test suite.  *#*#*#*#*#*#*#*#*#*");
    }

    @AfterSuite
    public void shutEnv() {
        if (driver != null) {
            driver.quit();
        }
    }
}