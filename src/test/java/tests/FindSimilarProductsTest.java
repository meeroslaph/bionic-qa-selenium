package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;
import utils.Log4Test;

public class FindSimilarProductsTest extends BaseTest {
    @Test(dataProvider = "products")
    public void findSimilarProducts(String[] products) {
        Log4Test.info("*** Start of findSimilarProducts test. ***");
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
        Log4Test.info("*** End of findSimilarProducts test. ***");
    }
}