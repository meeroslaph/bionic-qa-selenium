package pages;

import org.openqa.selenium.WebDriver;
import utils.Log4Test;

public class HomePage extends BasePage {
    private String url = "http://rozetka.com.ua/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        Log4Test.info("Open Home page.");
        driver.get(url);
    }

    public Boolean isOpened() {
        return driver.getCurrentUrl().equals(url);
    }
}