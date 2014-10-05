package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log4Test;

public class SearchResultPage extends BasePage {
    private static final By addToComparisonBtn = By.name("tocomparison");

    @FindBy(className = "g-i-list-title")
    private WebElement foundProductTitleLocator;
    @FindBy(xpath = "//*[@href and contains(text(), 'сравнению')]")
    private WebElement compareProductsLnk;
    @FindBy(xpath = "(//*[@name='topurchasesfromcatalog'])[1]")
    private WebElement buyBtn;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isProductFound(String productName) {
        Log4Test.info("Check that product is found.");
        return foundProductTitleLocator.getText().equals(productName);
    }

    public void addProductToComparison() {
        Log4Test.info("Add the product to comparison.");
        wait.until(ExpectedConditions.elementToBeClickable(addToComparisonBtn)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addToComparisonBtn));
    }

    public void compareProducts() {
        Log4Test.info("Open comparison page.");
        wait.until(ExpectedConditions.elementToBeClickable(compareProductsLnk)).click();
    }

    public void buyProduct() {
        Log4Test.info("Buy product.");
        wait.until(ExpectedConditions.elementToBeClickable(buyBtn)).click();
    }
}