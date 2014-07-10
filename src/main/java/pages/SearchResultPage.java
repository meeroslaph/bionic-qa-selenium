package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

public class SearchResultPage extends BasePage {
    private static final By foundProductTitle = By.className("g-i-list-title");
    private static final By addToComparisonBtn = By.name("tocomparison");
    private static final By compareProductsLnk = By.xpath("//*[@href and contains(text(), 'сравнению')]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isProductFound(String productName) {
        Log4Test.info("Check that product is found.");
        return driver.findElement(foundProductTitle).getText().equals(productName);
    }

    public void addProductToComparison() {
        Log4Test.info("Add the product to comparison.");
        driver.findElement(addToComparisonBtn).click();
    }

    public void compareProducts() {
        Log4Test.info("Open comparison page.");
        wait.until(ExpectedConditions.elementToBeClickable(compareProductsLnk)).click();
    }
}