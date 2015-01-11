package tests.basket;

import org.testng.annotations.DataProvider;

public class BasketData {
    @DataProvider(name = "basket")
    public static Object[][] createData() {
        return new Object[][]{
                {"Nokia 105 Black", "319", "грн"},
                {"Samsung PE-43H4500 (PE43H4500AKXUA)", "6 299", "грн"}
        };
    }
}