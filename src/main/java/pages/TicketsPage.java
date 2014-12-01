package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log4Test;

public class TicketsPage extends BasePage {
    private static final String adultsTicketsLocator = "//div[@class='adults_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final String childrenTicketsLocator = "//div[@class='children_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final String infantsTicketsLocator = "//div[@class='infants_block passengers_wrapper']/div[@class='persons']/div[%d]";

    @FindBy(id = "start_search")
    private WebElement searchBtn;
    @FindBy(xpath = "//*[@class='popup error_popup']")
    private WebElement errorPopup;

    public void buyTickets(int adults, int children, int infants) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        Log4Test.info("Buy tickets.");
        //Set default adult tickets amount to 0.
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
        searchBtn.click();
    }

    public boolean isErrorMessageDisplayed() {
        Log4Test.info("Check that error pop-up window is displayed.");
        return errorPopup.isDisplayed();
    }
}