package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log4Test;

public class SearchResultPage extends BasePage {
    @FindBy(name = "tocomparison")
    private WebElement addToComparisonBtn;
    @FindBy(className = "g-i-list-title")
    private WebElement foundProductTitle;
    @FindBy(xpath = "//*[@href and contains(text(), 'сравнению')]")
    private WebElement compareProductsLnk;
    @FindBy(xpath = "(//*[@name='topurchasesfromcatalog'])[1]")
    private WebElement buyBtn;

    public boolean isProductFound(String productName) {
        Log4Test.info("Check that product is found.");
        return foundProductTitle.getText().equals(productName);
    }

    public void addProductToComparison() {
        Log4Test.info("Add the product to comparison.");
        wait.until(ExpectedConditions.elementToBeClickable(addToComparisonBtn)).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(addToComparisonBtn)));
    }

    public CompareProductsPage compareProducts() {
        Log4Test.info("Open comparison page.");
        wait.until(ExpectedConditions.elementToBeClickable(compareProductsLnk)).click();
        return new CompareProductsPage();
    }

    public BasketPage buyProduct() {
        Log4Test.info("Buy product.");
        wait.until(ExpectedConditions.visibilityOf(addToComparisonBtn)); //Additional wait for Chrome support.
        wait.until(ExpectedConditions.elementToBeClickable(buyBtn)).click();
        return new BasketPage();
    }
}