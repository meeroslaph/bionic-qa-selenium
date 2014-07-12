package tests.products;

import org.testng.annotations.DataProvider;

public class ProductsData {
    @DataProvider(name = "products")
    public static Object[][] createData() {
        return new Object[][]{
                { new String[] {"Fly DS106D Black", "Nokia 107 Dual SIM Red"} },
                { new String[] {"Samsung UE-32H6410 (UE32H6410AUXUA)", "LG 39LB580V"} }
        };
    }
}