package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.WebDriverFactory;
import pages.SearchPage;
import pages.SearchResultsPage;

import java.util.List;

public class TestSearch {
    private WebDriver driver;
    private SearchPage searchPage;
    private SearchResultsPage searchResultsPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/yiyiliu/Desktop/chromedriver-mac-arm64/chromedriver");

        driver = WebDriverFactory.createDriver();
        searchPage = new SearchPage(driver);
        searchResultsPage = new SearchResultsPage(driver);


    }


    @DataProvider(name = "searchTerms")
    public Object[][] searchTerms() {
        return new Object[][]{
                {"cat"},
                {"dog"},
                {"rabbit"},
                // Add more search terms as needed
        };
    }

    @Test(dataProvider = "searchTerms")
    public void testSearch(String searchTerms) {




        //Act
        searchPage.openWebsite();//Can go to searchPage.openWebsite() to modify the website
        searchPage.enterSearchTerm(searchTerms); // Can enter search term also




        // Use a selector to locate the first result link on the Google search results page
        WebDriverWait wait = new WebDriverWait(driver, 10);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);










        //Assert
        Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed());
        // Capture the first result
        String firstResultText = searchResultsPage.getFirstSearchResultText();
        // Modify here can check if expected result in search results.
        //Assert.assertTrue(firstResultText.contains(searchTerms));





    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
