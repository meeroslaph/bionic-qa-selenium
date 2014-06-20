package testing;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by meeroslaph on 19.06.14.
 */
public class SortTest {
    private int[] toSort = {1,9,2,8,3,7,4,6,5};
    private int[] toCompare = {1,9,2,8,3,7,4,6,5};

    //@Parameters({ "toSort", "toCompare" }) I found it crazy to parse String into int[]!
    @Test
    public void sortTest() {
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

        Arrays.sort(toCompare);

        //Java's comparison
        assert Arrays.toString(toSort).equals(Arrays.toString(toCompare));

        //TestNG's comparison
        Assert.assertEquals(Arrays.toString(toSort), Arrays.toString(toCompare));
    }
}