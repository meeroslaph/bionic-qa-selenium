package tests.basket;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.SearchResultPage;
import tests.BaseTest;
import utils.Log4Test;

public class AddProductsToBasket extends BaseTest {
    @Test(dataProvider = "basket", dataProviderClass = BasketData.class)
    public void addProductsToBasket(String[] products, String price, String currency) {
        SearchResultPage searchResultPage = new SearchResultPage();
        for (String product : products) {
            searchResultPage.search(product);
            Assert.assertTrue(searchResultPage.isProductFound(product), Log4Test.error(product + " is not found."));
            searchResultPage.buyProduct();
        }
        BasketPage basketPage = new BasketPage();
        for (String product : products) {
            Assert.assertTrue(basketPage.checkProductTitle(product), Log4Test.error("Title of added product is not " + product + "."));
            Assert.assertTrue(basketPage.checkProductPrice(price, currency), Log4Test.error("Price of added product is not " + price));
        }
    }
}
