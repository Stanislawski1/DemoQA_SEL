package wrappers;


import elements.base.BaseElements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Buttons extends BaseElements {

    public Buttons(WebDriver driver, String text) {
        super(driver, By.xpath("//button[normalize-space(text())='" + text + "']"));
    }

    public Buttons(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public void click() {
        findElement().click();
    }

    public void jsClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", findElement());
    }

    public void actionClick() {
        new Actions(driver).moveToElement(findElement()).click().perform();
    }

    public void doubleClick() {
        new Actions(driver).doubleClick(findElement()).perform();
    }

    public void ctrlClick() {
        new Actions(driver).keyDown(Keys.CONTROL).click(findElement()).keyUp(Keys.CONTROL).perform();
    }

    public void rightClick() {
        new Actions(driver).contextClick(findElement()).perform();
    }

    public void hover() {
        new Actions(driver).moveToElement(findElement()).perform();
    }
}
