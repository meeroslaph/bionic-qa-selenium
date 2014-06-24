package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuySmartphone {
    @Test
    public void buySmartphoneTest() {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://rozetka.com.ua/");

        //verify that cart is empty
        Boolean isEmptyCart = driver.getPageSource().contains("m-cart-empty");
        Assert.assertTrue(isEmptyCart);

        //hover smartphones section
        Actions selectSmartphones = new Actions(driver);
        selectSmartphones.moveToElement(driver.findElement(By.id("phones-mp3-gps")));
        selectSmartphones.perform();

        //select smartphones
        WebElement smartphones = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"phones-mp3-gps\"]/div/div/ol/li[1]/ul[1]/li[1]/a")));
        smartphones.click();

        //select all smartphones
        driver.findElement(By.xpath("//*[@id=\"head_banner_container\"]/div[4]/div/div/div[2]/div[3]/ul/li[1]/ul/li[1]/a")).click();

        //sort smartphones by lowest price
        driver.findElement(By.xpath("//*[@id=\"sort_view\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"sort_view\"]/div/div/ul/li[1]/a")).click();

        //add the cheapest smartphone to the Cart
        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block_with_goods\"]/div[1]/div[1]/div[1]/div[1]/div/div/div[3]/div[2]/div/form/button")));
        addToCart.click();

        //verify that cart is not empty
        Assert.assertTrue(!(driver.findElement(By.className("uah")).getText().equals("0")));
        WebElement closeCartWindow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cart-popup\"]/div/a/img")));
        closeCartWindow.click();
        Boolean isFullCart = driver.getPageSource().contains("m-cart-full");
        Assert.assertTrue(isFullCart);

        driver.quit();
    }
}
