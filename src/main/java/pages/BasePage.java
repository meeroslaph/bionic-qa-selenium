package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LocalDriverManager;
import utils.Log4Test;

abstract public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@class='header-phones-numbers-i']")
    private WebElement helperLocator;
    @FindBy(className = "header-search-input-text")
    private WebElement searchInput;
    @FindBy(className = "btn-link-i")
    private WebElement searchBtn;
    @FindBy(id = "fatmenu_14")
    private WebElement ticketsCategoryLocator;
    @FindBy(xpath = "//*[contains(@href,'IEV/AMS')]")
    private WebElement flightDirectionLocator;

    BasePage() {
        driver = LocalDriverManager.getDriver();
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage search(String query) {
        Log4Test.info("Search for " + query + ".");
        searchInput.sendKeys(" ");
        helperLocator.click();
        searchInput.clear();
        searchInput.sendKeys(query);
        searchBtn.click();
        return new SearchResultPage();
    }

    public TicketsPage openAirTicketsPage() {
        Log4Test.info("Open air tickets page.");
        Actions selectTicketsCategory = new Actions(driver);
        selectTicketsCategory.moveToElement(ticketsCategoryLocator).perform();
        wait.until(ExpectedConditions.elementToBeClickable(flightDirectionLocator)).click();
        return new TicketsPage();
    }
}