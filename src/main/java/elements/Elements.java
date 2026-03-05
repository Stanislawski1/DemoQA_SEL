package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.DriverSingleton.driver;


public class Elements {

    // Login Page
    public static final By USERNAME_INPUT = By.id("userName");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login");

    public static void getSearchResultByText(String text) {
        String xpath = String.format("//a[contains(text(), '%s')]", text);
        driver.findElement(By.xpath(xpath));
    }

    // Book Store Page
    public static final By NEW_USER_BUTTON = By.xpath("//button[contains(text(), 'New User')]");
    public static final By REGISTER_BUTTON = By.id("register");
    public static final By SEARCH_INPUT = By.id("searchBox");


    public static WebElement getInvalidLoginMessage() {
        String xpath = "//p[contains(text(), 'Invalid username or password!')]";
        return driver.findElement(By.xpath(xpath));
    }
}
