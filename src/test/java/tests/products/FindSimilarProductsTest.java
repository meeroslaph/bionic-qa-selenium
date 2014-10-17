package tests.products;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import tests.BaseTest;
import utils.Log4Test;

public class FindSimilarProductsTest extends BaseTest {
    @Test(dataProvider = "products", dataProviderClass = ProductsData.class)
    public void findSimilarProducts(String[] products) {
        SearchResultPage searchResultPage = new SearchResultPage();
        for (String product : products) {
            searchResultPage.search(product);
            Assert.assertTrue(searchResultPage.isProductFound(product), Log4Test.error(product + " is not found."));
        }
    }
}