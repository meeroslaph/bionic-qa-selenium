package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log4Test;

public class BasketPage extends BasePage {
    @FindBy(className = "cart-title")
    private WebElement title;
    @FindBy(className = "no-visited")
    private WebElement productTitle;
    @FindBy(className = "cart-uah")
    private WebElement productPrice;
    @FindBy(className = "cart-amount")
    private WebElement productAmount;
    @FindBy(className = "cart-uah cart-sum-uah")
    private WebElement priceSum;
    @FindBy(className = "cart-total-uah")
    private WebElement priceTotal;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public Boolean checkProductTitle(String productName) {
        Log4Test.info("Check title of added product.");
        wait.until(ExpectedConditions.visibilityOf(productPrice));
        return productTitle.getText().equals(productName);
    }

    public Boolean checkProductPrice(String price, String currency) {
        Log4Test.info("Check price of added product.");
        wait.until(ExpectedConditions.visibilityOf(productPrice));
        return productPrice.getText().equals(price + " " + currency);
    }
}