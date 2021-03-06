package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.LocalDriverManager;
import utils.Log4Test;
import utils.PropertyLoader;
import utils.WebDriverFactory;

abstract public class BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        setUp();
        Log4Test.info("-_-_-_-_- Start of the test. -_-_-_-_-");
        HomePage homePage = new HomePage().openHomePage();
        Assert.assertTrue(homePage.isOpened(), "Home page is not open.");
    }

    @AfterMethod
    public void afterMethod() {
        Log4Test.info("-_-_-_-_-  End of the test.  -_-_-_-_-");
        tearDown();
    }

    private void setUp() {
        WebDriver driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        driver.manage().window().maximize();
        LocalDriverManager.setDriver(driver);
    }

    private void tearDown() {
        WebDriver driver = LocalDriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}