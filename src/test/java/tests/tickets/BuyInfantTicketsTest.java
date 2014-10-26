package tests.tickets;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TicketsPage;
import tests.BaseTest;

public class BuyInfantTicketsTest extends BaseTest {
    @Test(dataProvider = "tickets", dataProviderClass = TicketsData.class)
    public void buyInfantTickets(int adults, int children, int infants) {
        HomePage homePage = new HomePage();
        homePage.openAirTicketsPage();
        TicketsPage ticketsPage = new TicketsPage();
        ticketsPage.buyTickets(adults, children, infants);
        Assert.assertTrue(ticketsPage.isErrorMessageDisplayed(), "Error pop-up is not displayed.");
    }
}