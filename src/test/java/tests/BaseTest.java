package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class BaseTest {
    public static WebDriver driver;

    @DataProvider(name = "buyInfantTickets")
    public Object[][] createData1() {
        return new Object[][]{
                { 1, 0, 2 }
        };
    }

    @DataProvider(name = "products")
    public Object[][] createData() {
        return new Object[][]{
                { new String[] {"Fly DS106D Black", "Nokia 105 Black"} },
                { new String[] {"Маска AquaLung Infinity Red (108.710)", "Маска Cressi-Sub Perla Black (DN208150)"} }
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