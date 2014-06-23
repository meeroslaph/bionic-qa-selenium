package testing;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LengthTest {
    @DataProvider(name = "length")
    public Object[][] createData1() {
        return new Object[][] {
                { "1234567890" },
                { "abcdefghij" },
                { "klmnopqrst" }
        };
    }

    @Test(dataProvider = "length")
    public void testLength(String s) {
        Assert.assertTrue(s.length() == 10);
    }
}