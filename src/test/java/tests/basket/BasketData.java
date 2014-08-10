package tests.basket;

import org.testng.annotations.DataProvider;

public class BasketData {
    @DataProvider(name = "basket")
    public static Object[][] createData() {
        return new Object[][]{
                { new String[] {"Nokia 105 Black"}, "269", "грн." },
                { new String[] {"Samsung UE-32H6410 (UE32H6410AUXUA)"}, "7 399", "грн." }
        };
    }
}