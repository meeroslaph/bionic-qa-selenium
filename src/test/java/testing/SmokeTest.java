package testing;

import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 18.06.14
 * Time: 20:07
 * To change this template use File | Settings | File Templates.
 */
public class SmokeTest {
    private long a = 0;
    private int step = 1000;
    private Boolean overflow = false;

    @Test
    public void overflowTest() {
        while(!overflow) {
            if(a + step > Integer.MAX_VALUE) {
                overflow = true;
            }
            else {
                a = a + step;
            }
        }
        System.out.println("Oops! You are trying to assign " + (a + step) + " to your int out of " +
                Integer.MAX_VALUE + " allowed value. Your intended assignment exceeds maximum value of int by " +
                ((a + step) - Integer.MAX_VALUE) + ".");
    }
}
