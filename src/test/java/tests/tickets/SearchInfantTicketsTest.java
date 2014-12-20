package tests.tickets;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TicketsPage;
import tests.BaseTest;

public class SearchInfantTicketsTest extends BaseTest {
    @Test(dataProvider = "tickets", dataProviderClass = TicketsData.class)
    public void searchInfantTickets(int adults, int children, int infants) {
        TicketsPage ticketsPage = new HomePage().openAirTicketsPage();
        ticketsPage.searchTickets(adults, children, infants);
        Assert.assertTrue(ticketsPage.isErrorMessageDisplayed(), "Error pop-up is not displayed.");
    }
}