package tests.products;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductsPage;
import pages.SearchResultPage;
import tests.BaseTest;

public class CompareProductsDifferenceTest extends BaseTest {
    @Test(dataProvider = "products", dataProviderClass = ProductsData.class)
    public void compareProductsDifferenceTest(String[] products) {
        SearchResultPage searchResultPage = new SearchResultPage();
        for (String product : products) {
            searchResultPage.search(product);
            Assert.assertTrue(searchResultPage.isProductFound(product), product + " is not found.");
            searchResultPage.addProductToComparison();
        }
        searchResultPage.compareProducts();
        CompareProductsPage compareProductsPage = new CompareProductsPage();
        Assert.assertTrue(compareProductsPage.areProductsPresent(products), "Not all selected products are present in the comparison page.");
        Assert.assertTrue(compareProductsPage.compareProductsDifference(products), "Not all displayed properties are different.");
    }
}