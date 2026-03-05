package tests.UI;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test(description = "Авторизация пользователя с корректными данными")
    public void testOfLoginWithValidCredentials() {
        pageManager.getLoginPage().open()
                .loginWithCredentials("admin6", "Password123!")
                .checkLoginSuccessful();
    }

    @Test(description = "Авторизация пользователя с неверными данными")
    public void testOfLoginWithInvalidCredentials() {
        pageManager.getLoginPage().open()
                .loginWithInvalidCredentials("admin6", "WrongPassword!")
                .checkLoginSuccessful();
    }


    @Test(description = "Авторизация пользователя из базы данных")
    public void loginFromDatabase() {
        pageManager.getLoginPage().open()
                .loginFromDatabase();
    }

}
