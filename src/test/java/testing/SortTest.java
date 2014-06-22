package testing;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SortTest {
    @DataProvider(name = "sort")
    public Object[][] createData1() {
        return new Object[][] {
                { new int[] {1,9,2,8,3,7,4,6,5}, new int[] {1,9,2,8,3,7,4,6,5} },
        };
    }

    @Test(dataProvider = "sort")
    public void sortTest(int[] toSort, int[] toCompare) {
        int temp;

        for (int e = toSort.length - 1; e > 0; e--) {
            for (int j = 0; j < e; j++) {
                if (toSort[j] > toSort[j + 1]) {
                    temp = toSort[j];
                    toSort[j] = toSort[j + 1];
                    toSort[j + 1] = temp;
                }
            }
        }

        //Arrays.sort(toCompare);

        //Java's comparison
        assert Arrays.toString(toSort).equals(Arrays.toString(toCompare));

        //TestNG's comparison
        Assert.assertEquals(Arrays.toString(toSort), Arrays.toString(toCompare));
    }
}