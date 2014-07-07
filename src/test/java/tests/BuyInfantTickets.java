package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TicketsPage;
import utils.Log4Test;

import java.util.logging.Logger;

public class BuyInfantTickets extends BaseTest {
    @DataProvider(name = "buyInfantTickets")
    public Object[][] createData1() {
        return new Object[][]{
                { 0, 0, 2 }
        };
    }

    @Test(dataProvider = "buyInfantTickets")
    public void buyInfantTickets(int adults, int children, int infants) {
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.open();
        ticketsPage.isOpened();
        ticketsPage.buyTickets(adults, children, infants);
        Assert.assertTrue(ticketsPage.isError(), Log4Test.error("Error pop-up is not displayed."));
    }
}