package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class WebDriverFactory {
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

    public static WebDriver initDriver(String browserName) {
        WebDriver driver = null;
        if (browserName.equals(FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browserName.equals(CHROME)) {
            setChromeDriver();
            driver = new ChromeDriver();
        } else
            Assert.fail(Log4Test.error("WebDriver is not defined."));
        return driver;
    }

    private static void setChromeDriver() {
        String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
        if (os.equals("win") || os.equals("mac")) {
            String chromeBinary = "src/main/resources/drivers/chrome/chromedriver"
                    + (os.equals("win") ? ".exe" : "");
            System.setProperty("webdriver.chrome.driver", chromeBinary);
        } else {
            Assert.fail(Log4Test.error("There is no ChromeDriver for " + os + " OS in the resources of the project."));
        }
    }
}