package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import selenium.WebDriverWrapper;
import utils.Log4Test;

abstract public class BasePage {
    protected WebDriverWrapper driver;

    private static final By searchInput = By.className("header-search-input-text");
    private static final By searchBtn = By.className("btn-link-i");

    private static final By ticketsCategoryLocator = By.id("fatmenu_14");
    private static final By flightDirectionLocator = By.xpath("//*[contains(@href,'IEV/AMS')]");

    public BasePage(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void search(String query) {
        Log4Test.info("Search for " + query + ".");
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(query);
        driver.findElement(searchBtn).click();
    }

    public void openAirTicketsPage() {
        Log4Test.info("Open air tickets page.");
        Actions selectTicketsCategory = new Actions(driver);
        selectTicketsCategory.moveToElement(driver.findElement(ticketsCategoryLocator)).perform();
        driver.findElement(flightDirectionLocator).click();
    }
}