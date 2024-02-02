package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    private By searchBoxLocator;

    public SearchPage(WebDriver driver, String url, String searchEngine) {
        super(driver);
        driver.get(url);
        initializeSearchBoxLocator(searchEngine);
    }

    private void initializeSearchBoxLocator(String searchEngine) {
        switch (searchEngine.toLowerCase()) {
            case "google":
                searchBoxLocator = By.name("q");
                break;
            case "bing":
                searchBoxLocator = By.name("q");
                break;
            case "yahoo":
                searchBoxLocator = By.name("p");
                break;
            default:
                throw new IllegalArgumentException("Unsupported search engine: " + searchEngine);
        }
    }

    public void performSearch(String searchTerm) {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBoxLocator));

        findElement(searchBoxLocator).sendKeys(searchTerm);

        findElement(searchBoxLocator).submit();
    }

    public SearchPageResult getSearchResult() {
        return new SearchPageResult(driver);
    }
}
