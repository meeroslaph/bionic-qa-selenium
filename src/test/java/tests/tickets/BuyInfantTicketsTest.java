package tests.tickets;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TicketsPage;
import tests.BaseTest;
import tests.products.ProductsData;
import utils.Log4Test;

public class BuyInfantTicketsTest extends BaseTest {
    @Test(dataProvider = "tickets", dataProviderClass = TicketsData.class)
    public void buyInfantTickets(int adults, int children, int infants) {
        TicketsPage ticketsPage = new TicketsPage(driver);
        Log4Test.info("Open tickets page.");
        ticketsPage.open();
        Assert.assertTrue(ticketsPage.isOpened(), Log4Test.error("Tickets page is not opened."));
        ticketsPage.buyTickets(adults, children, infants);
        Assert.assertTrue(ticketsPage.isError(), Log4Test.error("Error pop-up is not displayed."));
    }
}