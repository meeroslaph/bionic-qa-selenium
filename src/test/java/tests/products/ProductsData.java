package tests.products;

import org.testng.annotations.DataProvider;

public class ProductsData {
    @DataProvider(name = "products")
    public static Object[][] createData() {
        return new Object[][]{
                {new String[]{"Fly DS106D Black", "Nokia 107 Dual SIM Red"}},
                {new String[]{"Samsung LT24D391EX/CI", "LG 39LB580V"}}
        };
    }
}