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
    @FindBy(css = "#search .g a")
    private WebElement firstSearchResult;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isSearchResultsDisplayed(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(firstSearchResult));

            return firstSearchResult.isDisplayed();

        }catch(NoSuchElementException e){
            return false;
        }

    }

    public String getFirstSearchResultText() {
        return firstSearchResult.getText();
    }




    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

    }



}
