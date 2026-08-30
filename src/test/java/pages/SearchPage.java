package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By searchBox = By.id("search_product");
    private final By searchButton = By.id("submit_search");

    private final By resultsHeading = By.cssSelector(".title.text-center");
    private final By productItems = By.cssSelector(".product-image-wrapper");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://automationexercise.com/products");
    }

    public void searchFor(String term) {
        driver.findElement(searchBox).sendKeys(term);
        driver.findElement(searchButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsHeading));
    }

    public String getResultsHeadingText() {
        return driver.findElement(resultsHeading).getText();
    }

    public int getResultCount() {
        List<org.openqa.selenium.WebElement> items = driver.findElements(productItems);
        return items.size();
    }
}
