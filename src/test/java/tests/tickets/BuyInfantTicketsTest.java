package tests.tickets;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TicketsPage;
import tests.BaseTest;
import tests.products.ProductsData;
import utils.Log4Test;

public class BuyInfantTicketsTest extends BaseTest {
    @Test(dataProvider = "tickets", dataProviderClass = TicketsData.class)
    public void buyInfantTickets(int adults, int children, int infants) {
        HomePage homePage = new HomePage(driver);
        homePage.openTicketsPage();
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.buyTickets(adults, children, infants);
        Assert.assertTrue(ticketsPage.isError(), Log4Test.error("Error pop-up is not displayed."));
    }
}