package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchPage;
import utils.WebDriverFactory;

public class SearchTest {
    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.createDriver();
    }

    @DataProvider(name = "searchEngines")
    public Object[][] searchEngines() {
        return new Object[][]{
                {"https://www.google.com", "Google"},
                {"https://www.bing.com", "Bing"},
                {"https://search.yahoo.com", "Yahoo"}
        };
    }

    @Test(dataProvider = "searchEngines")
    public void testSearchOnSearchEngines(String url, String searchEngine) {
        searchPage = new SearchPage(driver, url, searchEngine);
        performSearchTest(searchPage, searchEngine);
    }

    private void performSearchTest(SearchPage searchPage, String searchEngine) {
        searchPage.performSearch("cat");
        String actualResult = searchPage.getSearchResult().getFirstResultText(searchEngine);
        String expectedResult = "Cat";

        Assert.assertNotNull(actualResult);
        Assert.assertFalse(actualResult.isEmpty(), "Search on " + searchEngine + " failed");
        Assert.assertEquals(actualResult, expectedResult,
                searchEngine + "Not match with expectedResult");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
