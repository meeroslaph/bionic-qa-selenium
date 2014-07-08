package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TicketsPage;
import utils.Log4Test;

public class BuyInfantTicketsTest extends BaseTest {
    @Test(dataProvider = "buyInfantTickets")
    public void buyInfantTickets(int adults, int children, int infants) {
        Log4Test.info("*** Start of buyInfantTickets test. ***");
        TicketsPage ticketsPage = new TicketsPage(driver);
        Log4Test.info("Open tickets page.");
        ticketsPage.open();
        //TODO: Prevent showing error message when test has passed.
        Assert.assertTrue(ticketsPage.isOpened(), Log4Test.error("Tickets page is not opened."));
        Log4Test.info("Buy selected tickets.");
        ticketsPage.buyTickets(adults, children, infants);
        Assert.assertTrue(ticketsPage.isError(), Log4Test.error("Error pop-up is not displayed."));
        Log4Test.info("*** End of buyInfantTickets test. ***");
    }
}