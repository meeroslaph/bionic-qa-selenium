package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

import java.util.List;

public class CompareProductsPage extends BasePage {
    private static final By productTitleLocator = By.xpath("//*[@class='title']/a");
    private static final By showDifferenceLnk = By.xpath("//*[@href='#only-different']");

    WebDriverWait wait = new WebDriverWait(driver, 5);

    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }

    public Boolean areProductsPresent(String[] products) {
        Log4Test.info("Check that selected products are present in the comparison page.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitleLocator));
        Boolean result = false;
        List<WebElement> allComparedProducts = driver.findElements(productTitleLocator);
        for (int i = 0; i < allComparedProducts.size(); i++) {
            if (allComparedProducts.get(i).getText().equals(products[i])) {
                result = true;
            }
            else {
                return false;
            }
        }
        return result;
    }

    public void showDifference() {
        Log4Test.info("Show the difference between the selected products.");
        driver.findElement(showDifferenceLnk).click();
    }

    public Boolean compareProducts(String[] products) {
        Log4Test.info("Compare the difference between the selected products.");
        return false;
    }
}
