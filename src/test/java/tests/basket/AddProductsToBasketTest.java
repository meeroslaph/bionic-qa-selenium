package tests.basket;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.SearchResultPage;
import tests.BaseTest;

public class AddProductsToBasketTest extends BaseTest {
    @Test(dataProvider = "basket", dataProviderClass = BasketData.class)
    public void addProductsToBasket(String[] products, String price, String currency) {
        SearchResultPage searchResultPage = new SearchResultPage();
        for (String product : products) {
            searchResultPage.search(product);
            Assert.assertTrue(searchResultPage.isProductFound(product), product + " is not found.");
            searchResultPage.buyProduct();
        }
        BasketPage basketPage = new BasketPage();
        for (String product : products) {
            Assert.assertTrue(basketPage.checkProductTitle(product), "Title of added product is not " + product + ".");
            Assert.assertTrue(basketPage.checkProductPrice(price, currency), "Price of " + product + " is not " + price);
        }
    }
}