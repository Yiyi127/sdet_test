package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {
    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void openWebsite(){
        driver.get("https://www.google.com/imghp?hl=en");
    }

    public void enterSearchTerm(String term) {
        //searchBox.clear();
        searchBox.sendKeys(term);
        searchBox.sendKeys(Keys.RETURN);
    }
}
