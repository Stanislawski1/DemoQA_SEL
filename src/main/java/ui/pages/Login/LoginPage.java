package ui.pages.Login;

import database.DatabaseManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.pages.base.BasePage;
import ui.pages.BookStore.BookStorePage;
import wrappers.Buttons;

import java.util.Map;

import static elements.Elements.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        logger.info("Opening Login page");
        driver.get(BASE_URL + "login");
        return this;
    }

    public LoginPage loginWithCredentials(String username, String password) {
        logger.info("Logging in with credentials");
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public LoginPage loginWithInvalidCredentials(String username, String password) {
        logger.info("Logging in with invalid credentials");
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public LoginPage loginFromDatabase() {
        logger.info("Logging in from database");
        Map<String, String> creds = DatabaseManager.getUserCredentials("admin");
        driver.findElement(USERNAME_INPUT).sendKeys(creds.get("username"));
        driver.findElement(PASSWORD_INPUT).sendKeys(creds.get("password"));
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public LoginPage checkLoginSuccessful() {
        logger.info("Checking login successful");
        Assert.assertTrue(driver.findElement(PROFILE_LINK).isDisplayed(), "Login was not successful");
        return this;
    }

    public BookStorePage moveToBookStore() {
        logger.info("Moving to Book Store page");
        new Buttons(driver, "Go To Book Store").jsClick();
        return new BookStorePage(driver);
    }
}
