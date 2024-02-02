package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private final WebDriverWait wait;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    protected WebElement findElement(By locator) {
        try {
            System.out.println("Waiting for element to be visible: " + locator);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
           // return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found with locator: " + locator, e);
        }
    }
}
