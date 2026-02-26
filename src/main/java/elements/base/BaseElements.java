package elements.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseElements {

    protected final WebDriver driver;
    protected final By locator;
    protected final int timeoutInSeconds = 10;

    public BaseElements(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    protected WebElement findElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click() {
        findElement().click();
    }

    public String getText() {
        return findElement().getText();
    }

    public String getValue() {
        return findElement().getAttribute("value");
    }

    public boolean isDisplayed() {
        try {
            return findElement().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void scrollIntoView() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", findElement());
    }
}
