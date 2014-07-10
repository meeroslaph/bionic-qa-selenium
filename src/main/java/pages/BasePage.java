package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

abstract public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final By searchInput = By.className("header-search-input-text");
    private static final By searchBtn = By.className("btn-link-i");

    private static final By ticketsCategory = By.id("fatmenu_14");
    private static final By flightDirection = By.xpath("//a[contains(@*, 'travel/IEV/AMS')]");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void search(String query) {
        Log4Test.info("Search for product.");
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(query);
        driver.findElement(searchBtn).click();
    }

    public void openAirTicketsPage() {
        Log4Test.info("Open air tickets page.");
        Actions selectTicketsCategory = new Actions(driver);
        selectTicketsCategory.moveToElement(driver.findElement(ticketsCategory)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(flightDirection))).click();
    }
}