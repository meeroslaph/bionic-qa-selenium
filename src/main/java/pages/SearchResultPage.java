package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasePage {
    private static final By foundProductTitle = By.className("g-i-list-title");
    private static final By addToComparisonBtn = By.name("tocomparison");
    private static final By compareProductsLnk = By.xpath("//*[@href and contains(text(), 'сравнению')]");

    WebDriverWait wait = new WebDriverWait(driver, 5);

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isProductFound(String productName) {
        return driver.findElement(foundProductTitle).getText().equals(productName);
    }

    public void addProductToComparison() {
        driver.findElement(addToComparisonBtn).click();
    }

    public void compareProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(compareProductsLnk)).click();
    }
}