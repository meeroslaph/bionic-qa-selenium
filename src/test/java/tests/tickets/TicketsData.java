package tests.tickets;

import org.testng.annotations.DataProvider;

public class TicketsData {
    @DataProvider(name = "tickets")
    public static Object[][] createData() {
        return new Object[][]{
                { 1, 0, 2 }
        };
    }
}
