package tests.UI;

import org.testng.annotations.Test;
import tests.base.BaseTest;


public class LoginTest extends BaseTest {

    @Test
    public void testOfLoginWithValidCredentials() {
        pageManager.getLoginPage().open()
                .loginWithCredentials("admin6", "Password123!")
                .isLoginSuccessful();
    }

    @Test
    public void testOfLoginWithInvalidCredentials() {
        pageManager.getLoginPage().open()
                .loginWithInvalidCredentials("admin6", "WrongPassword!")
                .isLoginSuccessful();
    }

}
