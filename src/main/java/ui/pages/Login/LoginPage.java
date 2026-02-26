package ui.pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.BasePage;
import ui.pages.BookStore.BookStorePage;
import wrappers.Buttons;

import static elements.Elements.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        driver.get(BASE_URL + "login");
        return this;
    }

    public LoginPage loginWithCredentials(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public LoginPage loginWithInvalidCredentials(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Invalid username or password')]")).isDisplayed(), "Login was successful with invalid credentials");
        return this;
    }

    public LoginPage isLoginSuccessful() {
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(), 'Profile')]")).isDisplayed(), "Login was not successful");
        return this;
    }

    public BookStorePage moveToBookStore() {
        new Buttons(driver, "Go To Book Store").jsClick();
        return new BookStorePage(driver);
    }
}
