package utils;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/yiyiliu/Desktop/chromedriver-mac-arm64/chromedriver");
        return new ChromeDriver();
    }
}
