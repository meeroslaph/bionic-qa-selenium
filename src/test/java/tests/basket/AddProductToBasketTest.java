package tests.basket;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.HomePage;
import pages.SearchResultPage;
import tests.BaseTest;

public class AddProductToBasketTest extends BaseTest {
    @Test(dataProvider = "basket", dataProviderClass = BasketData.class)
    public void addProductsToBasket(String product, String price, String currency) {
        SearchResultPage searchResultPage = new HomePage().search(product);
        Assert.assertTrue(searchResultPage.isProductFound(product), product + " is not found.");
        BasketPage basketPage = searchResultPage.buyProduct();
        Assert.assertTrue(basketPage.checkProductTitle(product), "Title of added product is not " + product + ".");
        Assert.assertTrue(basketPage.checkProductPrice(price, currency), "Price of " + product + " is not " + price);
    }
}