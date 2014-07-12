package pages;

import org.openqa.selenium.By;
import selenium.WebDriverWrapper;
import utils.Log4Test;

public class SearchResultPage extends BasePage {
    private static final By foundProductTitleLocator = By.className("g-i-list-title");
    private static final By addToComparisonBtn = By.name("tocomparison");
    private static final By compareProductsLnk = By.xpath("//*[@href and contains(text(), 'сравнению')]");

    public SearchResultPage(WebDriverWrapper driver) {
        super(driver);
    }

    public Boolean isProductFound(String productName) {
        Log4Test.info("Check that product is found.");
        return driver.findElement(foundProductTitleLocator).getText().equals(productName);
    }

    public void addProductToComparison() {
        Log4Test.info("Add the product to comparison.");
        wait.until(ExpectedConditions.elementToBeClickable(addToComparisonBtn)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addToComparisonBtn));
    }

    public void compareProducts() {
        Log4Test.info("Open comparison page.");
        driver.findElement(compareProductsLnk).click();
    }
}