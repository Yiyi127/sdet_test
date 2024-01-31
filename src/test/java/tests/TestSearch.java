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



        By imageSelector = By.cssSelector(".rg_i");

        // Wait for the images to be present on the page
        searchResultsPage.waitForPageToLoad();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(imageSelector));


        // Get the list of image elements
        List<WebElement> images = driver.findElements(imageSelector);



        // Click the first 10 images
        int numberOfImagesToClick = Math.min(images.size(), 10);
        for (int i = 0; i < numberOfImagesToClick; i++) {
            WebElement image = images.get(i);
            // Wait for the image to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(image));

            image.click();
        }



        //Assert

        Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed());
        Assert.assertTrue(searchResultsPage.getSearchResultsCount() > 0);




    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
