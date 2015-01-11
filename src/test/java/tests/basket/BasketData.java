package tests.basket;

import org.testng.annotations.DataProvider;

public class BasketData {
    @DataProvider(name = "basket")
    public static Object[][] createData() {
        return new Object[][]{
                {"Nokia 105 Black", "399", "грн"},
                {"Samsung PE43H4500", "5 901", "грн"}
        };
    }
}