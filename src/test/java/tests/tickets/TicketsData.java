package tests.tickets;

import org.testng.annotations.DataProvider;

public class TicketsData {
    @DataProvider(name = "tickets")
    public static Object[][] createData() {
        return new Object[][]{
                {1, 0, 2},
                {1, 0, 3},
                {2, 0, 3}
        };
    }
}