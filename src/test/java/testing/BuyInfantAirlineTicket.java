package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    private static final By ticketsCategory = By.id("fatmenu_14");
    private static final By flightDirection = By.xpath("//a[contains(@*, 'travel/IEV/AMS')]");
    private static final By personUnit = By.xpath("//*[@data-field=\"infants\"]/*[@class=\"persons\"]/div[1]");
    private static final By searchButton = By.id("start_search");
    private static final By errorPopup = By.xpath("//*[@class=\"popup error_popup\"]");

    @DataProvider(name = "infantTickets")
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

    @Test(dataProvider = "infantTickets")
    public void buyInfantAirlineTicket(int numberOfInfants) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Actions selectFlight = new Actions(driver);
        selectFlight.moveToElement(driver.findElement(ticketsCategory)).perform();

        wait.until(ExpectedConditions.elementToBeClickable(flightDirection)).click();

        wait.until(ExpectedConditions.elementToBeClickable(personUnit));
        for (int i = 1; i <= numberOfInfants; i++) {
            driver.findElement(By.xpath("//*[@data-field=\"infants\"]/*[@class=\"persons\"]/div[" + Integer.toString(i) + "]")).click();
        }

        driver.findElement(searchButton).click();

        String errorMessage = "Младенцев не может быть больше, чем взрослых(младенцев - " + Integer.toString(numberOfInfants) + ", взрослых - 1)";

        Assert.assertTrue(driver.findElement(errorPopup).getText().equals(errorMessage));
    }

    @AfterSuite
    public void shutEnv() {
        if (driver != null) {
            driver.quit();
        }
    }
}