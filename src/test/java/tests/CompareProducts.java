package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareProducts {
    public static WebDriver driver;

    private static final By addToCompareBtn = By.name("tocomparison");
    private static final By compareBtn = By.xpath("//*[@name='comparison_details']/a");

    List<HashMap<String, String>> productDetails = new ArrayList<HashMap<String, String>>();

    @DataProvider(name = "productsToCompare")
    public Object[][] createData1() {
        return new Object[][]{
                { 2 }
        };
    }

    @BeforeSuite
    public void intEnv() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://rozetka.com.ua/");
    }

    @Test(dataProvider = "productsToCompare")
    public void compareProducts(int numberOfProducts) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Actions selectCategory = new Actions(driver);
        selectCategory.moveToElement(driver.findElement(By.id("computers-notebooks"))).perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'fat-link3') and contains(@href, 'notebooks')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@href, 'c80004/filter')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class=\"gtile-i-title\"]/a"))));

        for (int i = 0; i < numberOfProducts; i++) {
            List<WebElement> allProducts = driver.findElements(By.xpath("//*[@class=\"gtile-i-title\"]/a"));
            allProducts.get(i).click();
            driver.findElement(addToCompareBtn).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.name("characteristics"))).click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"tab_content\"]/div/div/div[1]/div[1]/div[1]")));

            List<WebElement> allDetailsElements = driver.findElements(By.className("detail-tab-characteristics-i"));
            HashMap<String, String> titleAndValue = new HashMap<String, String>();
            for (WebElement e : allDetailsElements) {
                String title = e.findElement(By.className("detail-tab-characteristics-i-title")).getText();
                String value = e.findElement(By.className("detail-tab-characteristics-i-field")).getText();
                titleAndValue.put(title, value);
            }
            productDetails.add(titleAndValue);

            if (i+1 == numberOfProducts) {
                Actions compareProds = new Actions(driver);
                compareProds.moveToElement(driver.findElement(compareBtn)).perform();
                driver.findElement(compareBtn).click();
            }
            else {
                driver.get("http://rozetka.com.ua/notebooks/c80004/filter");
            }
        }
    }

    //@AfterSuite
    public void shutEnv() {
        if (driver != null) {
            driver.quit();
        }
    }
}
