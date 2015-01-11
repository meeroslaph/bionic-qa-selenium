package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log4Test;

public class SearchResultPage extends BasePage {
    @FindBy(name = "tocomparison")
    private WebElement addToComparisonBtn;
    @FindBy(className = "g-i-list-title")
    private WebElement foundProductTitle;
    @FindBy(xpath = "//*[@id='head_banner_container']//a[@class='lightblue underline']")
    private WebElement compareProductsLnk;
    @FindBy(xpath = "(//*[@name='topurchasesfromcatalog'])[1]")
    private WebElement buyBtn;

    public boolean isProductFound(String productName) {
        Log4Test.info("Check that product is found.");
        return foundProductTitle.getText().equals(productName);
    }

    public SearchResultPage addProductToComparison() {
        Log4Test.info("Add the product to comparison.");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(addToComparisonBtn)).click();
        } catch (StaleElementReferenceException ex) {
            addToComparisonBtn.click();
        }
        return this;
    }

    public CompareProductsPage compareProducts() {
        Log4Test.info("Open comparison page.");
        wait.until(ExpectedConditions.elementToBeClickable(compareProductsLnk)).click();
        return new CompareProductsPage();
    }

    public BasketPage buyProduct() {
        Log4Test.info("Buy product.");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(buyBtn)).click();
        } catch (StaleElementReferenceException ex) {
            buyBtn.click();
        }
        return new BasketPage();
    }
}