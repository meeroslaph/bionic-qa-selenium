package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log4Test;

public class BasketPage extends HomePage {
    private static final By title = By.className("cart-title");
    private static final By productTitle = By.className("no-visited");
    private static final By productPrice = By.className("cart-uah");
    private static final By productAmount = By.className("cart-amount");
    private static final By priceSum = By.className("cart-uah cart-sum-uah");
    private static final By priceTotal = By.className("cart-total-uah");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public Boolean checkProductTitle(String productName) {
        Log4Test.info("Check title of added product.");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productPrice));
        return driver.findElement(productTitle).getText().equals(productName);
    }

    public Boolean checkProductPrice(String price, String currency) {
        Log4Test.info("Check price of added product.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        return driver.findElement(productPrice).getText().equals(price + " " + currency);
    }
}
