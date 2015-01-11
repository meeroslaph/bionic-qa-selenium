package tests.products;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductsPage;
import pages.SearchResultPage;
import tests.BaseTest;

public class CompareProductsTest extends BaseTest {
    @Test(dataProvider = "products", dataProviderClass = ProductsData.class)
    public void compareProducts(String[] products) {
        SearchResultPage searchResultPage = new SearchResultPage();
        for (String product : products) {
            searchResultPage.search(product);
            Assert.assertTrue(searchResultPage.isProductFound(product), product + " is not found.");
            searchResultPage.addProductToComparison();
        }
        CompareProductsPage compareProductsPage = searchResultPage.compareProducts();
        Assert.assertTrue(compareProductsPage.areProductsPresent(products), "Not all selected products are present in the comparison page.");
    }
}