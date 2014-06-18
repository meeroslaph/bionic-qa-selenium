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
    @Test
    public void sTest() {
        //int a = 100000;
        for(int a = 10000000; a <= 2147483647; a++) {
        }
        System.out.println("The");
    }
}
