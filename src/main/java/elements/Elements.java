package elements;

import org.openqa.selenium.By;

public class Elements {

    // Login Page
    public static final By USERNAME_INPUT = By.id("userName");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login");

    // Book Store Page
    public static final By NEW_USER_BUTTON = By.xpath("//button[contains(text(), 'New User')]");
    public static final By REGISTER_BUTTON = By.id("register");
    public static final By SEARCH_INPUT = By.id("searchBox");
}
