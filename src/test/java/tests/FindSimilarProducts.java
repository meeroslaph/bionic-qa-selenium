package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindSimilarProducts {
    public static WebDriver driver;

    @DataProvider(name = "similarProducts")
    public Object[][] createData1() {
        return new Object[][]{
                { 2 }
        };
    }

    @BeforeSuite
    public void intEnv() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://rozetka.com.ua/");
    }

    @Test(dataProvider = "similarProducts")
    public void findSimilarProducts(int numberOfProducts) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Actions selectCategory = new Actions(driver);
        selectCategory.moveToElement(driver.findElement(By.id("computers-notebooks"))).perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'fat-link3') and contains(@href, 'notebooks')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@href, 'c80004/filter')]"))).click();
    }

    @AfterSuite
    public void shutEnv() {
        if (driver != null) {
            driver.quit();
        }
    }
}