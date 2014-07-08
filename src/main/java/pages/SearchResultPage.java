package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    private static final By searchInput = By.xpath("//*[@class='header-search-field-text']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void search(String query) {}
}
