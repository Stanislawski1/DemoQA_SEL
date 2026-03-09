package ui.pages.Elements;

import com.github.javafaker.Faker;
import dto.FormData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import ui.BasePage;
import wrappers.*;

import static elements.Elements.*;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ElementsPage isPageOpened() {
        logger.info("Checking Elements page opened");
        waitForPageLoaded();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ELEMENTS_TITLE));
        return this;
    }

    public ElementsPage useTextBox(FormData form) {
        logger.info("Using Text Box");
        org.openqa.selenium.WebElement el = driver.findElement(TEXT_BOX_BUTTON);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
        el.click();
        form.applyTextBox(driver, form);
        org.openqa.selenium.WebElement element = driver.findElement(SUBMIT_BUTTON);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_MESSAGE));
        logger.info("Text Box successfully used");
        return this;
    }

    public ElementsPage useRadioButton() {
        logger.info("Using RadioButton");
        driver.findElement(RADIO_BUTTON_SECTION).click();
        new RadioButton(driver, "Impressive").select();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='text-success']")).getText(), "Impressive");
        logger.info("RadioButton successfully used");
        return this;
    }

    public ElementsPage useWebTables(FormData form) {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        logger.info("Using Web Tables");
        driver.findElement(WEB_TABLES_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addNewRecordButton")));
        driver.findElement(By.id("addNewRecordButton")).click();
        form.fillFirstName(driver, form);
        form.useWebPages(driver, form);
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("submit")).isDisplayed();
        logger.info("Web Tables successfully used");
        return this;
    }

    public ElementsPage useButtons() {
        logger.info("Using Buttons");
        driver.findElement(BUTTONS).click();
        SoftAssert softAssert = new SoftAssert();
        new Buttons(driver, "Right Click Me").rightClick();
        softAssert.assertEquals(driver.findElement(By.id("rightClickMessage")).getText(),
                "You have done a right click");
        new Buttons(driver, "Double Click Me").doubleClick();
        softAssert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(),
                "You have done a double click");
        new Buttons(driver, "Click Me").click();
        softAssert.assertEquals(driver.findElement(By.id("dynamicClickMessage")).getText(),
                "You have done a dynamic click");
        logger.info("Buttons successfully used");
        return this;
    }

    public ElementsPage useLinks(String linkText, String expectedUrlPart) {
        logger.info("Using Links");
        driver.findElement(By.xpath("//span[contains(text(),'Links')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkText)));
        driver.findElement(By.xpath(linkText)).click();
        wait.until(ExpectedConditions.urlContains(expectedUrlPart));
        logger.info("Links successfully used");
        return this;
    }

    public ElementsPage useResponse(String linkText, String expectedStatus) {
        logger.info("Using Response");
        wait.until(ExpectedConditions.visibilityOfElementLocated(LINKS));
        driver.findElement(LINKS).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
        driver.findElement(By.linkText(linkText)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        Assert.assertTrue(driver.findElement(By.id("linkResponse")).getText().contains(expectedStatus));
        logger.info("Response successfully used");
        return this;
    }

}
