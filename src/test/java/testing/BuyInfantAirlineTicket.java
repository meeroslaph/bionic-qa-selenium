package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BuyInfantAirlineTicket {
    public static WebDriver driver;

    @DataProvider(name = "infantTicket")
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

    @Test(dataProvider = "infantTicket")
    public void buyInfantAirlineTicket(int numberOfTickets) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Actions selectFlight = new Actions(driver);
        selectFlight.moveToElement(driver.findElement(By.id("fatmenu_14")));
        selectFlight.perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@*, 'travel/IEV/AMS')]")));
        driver.findElement(By.xpath("//a[contains(@*, 'travel/IEV/AMS')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-field=\"infants\"]/*[@class=\"persons\"]/div[1]")));
        for (int i = 1; i <= numberOfTickets; i++) {
            driver.findElement(By.xpath("//*[@data-field=\"infants\"]/*[@class=\"persons\"]/div[" + Integer.toString(i) + "]")).click();
        }

        driver.findElement(By.id("start_search")).click();

        WebElement errorPopup = driver.findElement(By.xpath("//*[@class=\"popup error_popup\"]"));

        Assert.assertTrue(errorPopup.isDisplayed());
    }

    @AfterSuite
    public void shutEnv() {
        if (driver != null) {
            driver.quit();
        }
    }
}