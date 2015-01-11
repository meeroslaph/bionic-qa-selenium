package tests.basket;

import org.testng.annotations.DataProvider;

public class BasketData {
    @DataProvider(name = "basket")
    public static Object[][] createData() {
        return new Object[][]{
                {"Nokia 105 Black", "399", "грн"},
                {"Genius KB-110 PS/2 (31300689104)", "121", "грн"}
        };
    }
}