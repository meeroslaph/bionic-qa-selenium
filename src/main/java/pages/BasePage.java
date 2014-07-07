package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

abstract public class BasePage {
    protected WebDriver driver;
    protected String url;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public Boolean isOpened() {
        return driver.getCurrentUrl().equals(url);
    }
}
