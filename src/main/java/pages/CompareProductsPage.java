package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log4Test;

import java.util.ArrayList;
import java.util.List;

public class CompareProductsPage extends BasePage {
    private static final By productTitleLocator = By.xpath("//*[@class='title']/a");
    private static final By showDifferenceLnk = By.xpath("//*[@href='#only-different']");
    private static final By productsKeysLocator = By.xpath("//td[@class='detail-title']");
    private static final By productsDifferentKeysLocator = By.xpath("//tr[contains(@class, 'different')]/td[1]");
    private static final String productValuesLocator = "//td[@class='detail-title']/ancestor::tr/td[%d]";

    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }

    public Boolean areProductsPresent(String[] products) {
        Log4Test.info("Check that selected products are present in the comparison page.");
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

    public Boolean compareProductsDifference(String[] products) {
        Log4Test.info("Compare the difference between the selected products.");
        List<WebElement> productsKeys = getProductsKeys();
        List<List<WebElement>> productsValues = new ArrayList<List<WebElement>>();
        for (int i = 2; i <= products.length + 1; i++) {
            productsValues.add(getProductValues(i));
        }
        List<String> calculatedDifferentKeys = calculateDifferentKeys(productsKeys, productsValues);
        showDifference();
        List<String> differentKeys = getDifferentProductKeys();
        return calculatedDifferentKeys.size() == differentKeys.size() && calculatedDifferentKeys.containsAll(differentKeys);
    }

    public List<WebElement> getProductsKeys() {
        return driver.findElements(productsKeysLocator);
    }

    public List<WebElement> getProductValues(int i) {
        return driver.findElements(By.xpath(String.format(productValuesLocator, i)));
    }

    public List<String> getDifferentProductKeys() {
        List<String> differentKeys = new ArrayList<String>();
        List<WebElement> foundDifferentKeys = driver.findElements(productsDifferentKeysLocator);
        for (WebElement element : foundDifferentKeys) {
            differentKeys.add(element.getText());
        }
        return differentKeys;
    }

    //TODO: Improve the method to handle more than 2 products more robust.
    public List<String> calculateDifferentKeys(List<WebElement> productKeys, List<List<WebElement>> productsValues) {
        List<String> differentKeys = new ArrayList<String>();
        for (int i = 0; i < productKeys.size(); i++) {
            if (!productsValues.get(0).get(i).getText().equals(productsValues.get(1).get(i).getText())) {
                differentKeys.add(productKeys.get(i).getText());
            }
        }
        return differentKeys;
    }
}
