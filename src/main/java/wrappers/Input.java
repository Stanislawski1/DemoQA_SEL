package wrappers;
import elements.base.BaseElements;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Input extends BaseElements {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By locator;


    public Input(WebDriver driver, By locator) {
        super(driver, locator);
        this.driver = driver;
        this.locator = locator;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public Input(WebDriver driver, By locator, int timeoutSeconds) {
        super(driver, locator);
        this.driver = driver;
        this.locator = locator;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    public Input(WebDriver driver, String label) {
        this(driver, buildLocatorFromLabel(label));
    }

    public void write(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }

    public void clear() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }

    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute("value");
    }

    public boolean isVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static By buildLocatorFromLabel(String label) {
        String esc = escapeForXPath(label);
        String xpath = "//label[contains(normalize-space(.)," + esc + ")]//following::input[1]"
                + " | //input[contains(normalize-space(@placeholder)," + esc + ") or @id=" + esc + " or @name=" + esc + "]";
        return By.xpath(xpath);
    }

    private static String escapeForXPath(String input) {
        if (!input.contains("'")) {
            return "'" + input + "'";
        }
        String[] parts = input.split("'");
        StringBuilder sb = new StringBuilder("concat(");
        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                sb.append(", \"'\", ");
            }
            sb.append("'").append(parts[i]).append("'");
        }
        sb.append(")");
        return sb.toString();
    }
}