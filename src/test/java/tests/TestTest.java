package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class TestTest {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void test() {
        driver.get("http://rozetka.com.ua/acer_aspire_v5-123-12102g32nkk_nx_mfequ_010_black/p447434/#tab=characteristics");
        List<WebElement> allInnerElements = driver.findElements(By.className("detail-tab-characteristics-i"));
        //HashMap<String, String> finalElements = new HashMap<String, String>();
        for (WebElement e : allInnerElements) {
            String title = e.findElement(By.className("detail-tab-characteristics-i-title")).getText();
            String value = e.findElement(By.className("detail-tab-characteristics-i-field")).getText();
            System.out.println(title + " " + " " + value);
        }
    }
}
