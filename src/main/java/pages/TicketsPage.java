package pages;

import org.openqa.selenium.By;
import selenium.WebDriverWrapper;
import utils.Log4Test;

public class TicketsPage extends BasePage {
    private static final String adultsTicketsLocator = "//div[@class='adults_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final String childrenTicketsLocator = "//div[@class='children_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final String infantsTicketsLocator = "//div[@class='infants_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final By searchBtn = By.id("start_search");
    private static final By errorPopup = By.xpath("//*[@class='popup error_popup']");

    public TicketsPage(WebDriverWrapper driver) {
        super(driver);
    }

    public void buyTickets(int adults, int children, int infants) {
        Log4Test.info("Buy tickets.");
        driver.findElement(By.xpath(String.format(adultsTicketsLocator, 1))).click();
        if (adults != 0) {
            driver.findElement(By.xpath(String.format(adultsTicketsLocator, adults))).click();
        }
        if (children != 0) {
            driver.findElement(By.xpath(String.format(childrenTicketsLocator, children))).click();
        }
        if (infants != 0) {
            driver.findElement(By.xpath(String.format(infantsTicketsLocator, infants))).click();
        }
        driver.findElement(searchBtn).click();
    }

    public Boolean isError() {
        Log4Test.info("Check that error pop-up window is displayed.");
        return driver.findElements(errorPopup).size() > 0;
    }
}