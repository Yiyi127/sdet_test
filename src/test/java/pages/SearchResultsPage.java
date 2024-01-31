package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class SearchResultsPage extends BasePage {
    @FindBy(className = "Q4LuWd")
    private List<WebElement> searchResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isSearchResultsDisplayed(){
        try{
            WebElement searchResults = driver.findElement(By.className("Q4LuWd"));
            return searchResults.isDisplayed();

        }catch(NoSuchElementException e){
            return false;
        }

    }

    public int getSearchResultsCount(){
        try{
            List<WebElement> searchResults = driver.findElements(By.className("Q4LuWd"));
            return searchResults.size();
        }
        catch(NoSuchElementException e){
            return 0;
        }
    }


    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".rg_i")));
    }
}
