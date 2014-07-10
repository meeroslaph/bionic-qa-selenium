package tests.products;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductsPage;
import pages.HomePage;
import pages.SearchResultPage;
import tests.BaseTest;
import utils.Log4Test;

public class CompareProductsDifferenceTest extends BaseTest {
    @Test(dataProvider = "products", dataProviderClass = ProductsData.class)
    public void compareProductsDifferenceTest(String[] products) {
        HomePage homePage = new HomePage(driver);
        Log4Test.info("Open home page.");
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), Log4Test.error("Home page is not opened."));
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        for (String product : products) {
            Log4Test.info("Search for " + product + ".");
            searchResultPage.search(product);
            Assert.assertTrue(searchResultPage.isProductFound(product), Log4Test.error(product + " is not found."));
            Log4Test.info("Add product to comparison.");
            searchResultPage.addProductToComparison();
        }
        Log4Test.info("Compare selected products.");
        searchResultPage.compareProducts();
        CompareProductsPage compareProductsPage = new CompareProductsPage(driver);
        Assert.assertTrue(compareProductsPage.areProductsPresent(products), Log4Test.error("Not all selected products are presented in the comparison page."));
        Log4Test.info("Show difference between the displayed products.");
        compareProductsPage.showDifference();
        Log4Test.info("Compare different properties in the displayed products.");
        Assert.assertTrue(compareProductsPage.compareProducts(products), Log4Test.error("Not all displayed properties are different."));
    }
}