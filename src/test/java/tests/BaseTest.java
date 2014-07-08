package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class BaseTest {
    public static WebDriver driver;

    @DataProvider(name = "products")
    public Object[][] createData() {
        return new Object[][]{
                { 2, new String[] {"Apple iPhone 5s 16GB Space Gray UACRF", "Nokia Lumia 920 Yellow"} }
        };
    }

    @BeforeSuite
    public void intEnv() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void shutEnv() {
        if (driver != null) {
            driver.quit();
        }
    }
}