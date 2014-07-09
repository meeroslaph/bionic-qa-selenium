package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CompareProductsPage extends BasePage {
    private static final By productTitleLocator = By.xpath("//*[@class='title']/a");
    private static final By showDifferenceLnk = By.xpath("//*[@href='#only-different']");

    WebDriverWait wait = new WebDriverWait(driver, 5);

    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }

    public Boolean areProductsPresent(String[] products) {
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
        driver.findElement(showDifferenceLnk).click();
    }

    public Boolean compareProducts(String[] products) {
        return false;
    }
}
