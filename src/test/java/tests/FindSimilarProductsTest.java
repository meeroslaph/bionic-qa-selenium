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
        for (int i = 0; i < products.length; i++) {
            Log4Test.info("Search for " + products[i] + ".");
            searchResultPage.search(products[i]);
            Assert.assertTrue(searchResultPage.isProductFound(products[i]), Log4Test.error(products[i] + " is not found."));
        }
        Log4Test.info("*** End of findSimilarProducts test. ***");
    }
}