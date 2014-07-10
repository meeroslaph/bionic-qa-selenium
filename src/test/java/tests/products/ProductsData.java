package tests.products;

import org.testng.annotations.DataProvider;

public class ProductsData {
    @DataProvider(name = "products")
    public static Object[][] createData() {
        return new Object[][]{
                { new String[] {"Fly DS106D Black", "Nokia 105 Black"} },
                { new String[] {"Маска AquaLung Infinity Red (108.710)", "Маска Cressi-Sub Perla Black (DN208150)"} }
        };
    }
}
