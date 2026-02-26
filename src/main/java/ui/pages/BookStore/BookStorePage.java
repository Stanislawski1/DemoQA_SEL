package ui.pages.BookStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ui.BasePage;
import static elements.Elements.*;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BookStorePage isPageOpened() {
        waitForPageLoaded();
        return this;
    }

    public BookStorePage useSearch(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT));
        driver.findElement(SEARCH_INPUT).sendKeys("Programming JavaScript Applications");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(), '" + text + "')]")).isDisplayed(), "No results found for search");
        return this;
    }
}
