package ui.pages.BookStore;

import elements.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.pages.base.BasePage;
import static elements.Elements.*;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BookStorePage isPageOpened() {
        logger.info("Checking if Book Store page is opened");
        waitForPageLoaded();
        return this;
    }

    public BookStorePage useSearchNCheck(String text) {
        logger.info("Using search and checking result");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT));
        driver.findElement(SEARCH_INPUT).sendKeys("Programming JavaScript Applications");
        Elements.getSearchResultByText(text);
        logger.info("Search result found");
        return this;
    }
}
