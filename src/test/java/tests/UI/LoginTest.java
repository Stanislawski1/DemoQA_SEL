package tests.UI;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.property.PropertyConfig;

public class LoginTest extends BaseTest {

    @Test(description = "Авторизация пользователя с корректными данными")
    public void testOfLoginWithValidCredentials() {
        pageManager.getLoginPage().open()
                .loginWithCredentials(PropertyConfig.getApiUsername(), PropertyConfig.getApiPassword())
                .checkLoginSuccessful();
    }

    @Test(description = "Авторизация пользователя с неверными данными")
    public void testOfLoginWithInvalidCredentials() {
        pageManager.getLoginPage().open()
                .loginWithInvalidCredentials(PropertyConfig.getApiUsername(), "WrongPassword!")
                .checkLoginSuccessful();
    }

    @Test(description = "Авторизация пользователя из базы данных")
    public void loginFromDatabase() {
        pageManager.getLoginPage().open()
                .loginFromDatabase();
    }
}
