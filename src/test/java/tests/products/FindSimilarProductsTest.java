package tests.products;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;
import tests.BaseTest;
import utils.Log4Test;

public class FindSimilarProductsTest extends BaseTest {
    @Test(dataProvider = "products", dataProviderClass = ProductsData.class)
    public void findSimilarProducts(String[] products) {
        HomePage homePage = new HomePage(driver);
        Log4Test.info("Open home page.");
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), Log4Test.error("Home page is not opened."));
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        for (String product : products) {
            Log4Test.info("Search for " + product + ".");
            searchResultPage.search(product);
            Assert.assertTrue(searchResultPage.isProductFound(product), Log4Test.error(product + " is not found."));
        }
    }
}