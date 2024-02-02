package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPageResult extends BasePage {
    private By firstResultLocatorGoogle = By.cssSelector("h3");
    private By firstResultLocatorBing = By.cssSelector("h2");
    private By firstResultLocatorYahoo = By.cssSelector("h3.title");

    public SearchPageResult(WebDriver driver) {
        super(driver);
    }

    public String getFirstResultText(String searchEngine) {
        By firstResultLocator = getFirstResultLocator(searchEngine);
        return findElement(firstResultLocator).getText();
    }

    private By getFirstResultLocator(String searchEngine) {
        switch (searchEngine.toLowerCase()) {
            case "google":
                return firstResultLocatorGoogle;
            case "bing":
                return firstResultLocatorBing;
            case "yahoo":
                return firstResultLocatorYahoo;
            default:
                throw new IllegalArgumentException("Unsupported search engine: " + searchEngine);
        }
    }
}
