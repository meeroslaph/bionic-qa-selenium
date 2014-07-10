package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        Log4Test.info("*#*#*#*#*#* Start of the test suite. *#*#*#*#*#*");
    }

    @BeforeMethod
    public void beforeMethod() {
        Log4Test.info("-_-_-_-_- Start of the test. -_-_-_-_-");
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), Log4Test.error("Home page is not open."));
    }

    @AfterMethod
    public void afterMethod() {
        Log4Test.info("-_-_-_-_-  End of the test.  -_-_-_-_-");
    }

    @AfterTest
    public void afterTest() {
        Log4Test.info("*#*#*#*#*#*  End of the test suite.  *#*#*#*#*#*");
    }

    @AfterSuite
    public void shutEnv() {
        if (driver != null) {
            driver.quit();
        }
    }
}