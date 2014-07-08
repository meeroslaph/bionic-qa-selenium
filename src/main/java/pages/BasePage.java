package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

abstract public class BasePage {
    protected WebDriver driver;
    protected String url;

    private static final By searchInput = By.className("header-search-input-text");
    private static final By searchBtn = By.className("btn-link-i");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public Boolean isOpened() {
        return driver.getCurrentUrl().equals(url);
    }

    public void search(String query) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(query);
        driver.findElement(searchBtn).click();
    }
}