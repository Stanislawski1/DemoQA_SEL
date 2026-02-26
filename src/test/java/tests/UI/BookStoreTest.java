package tests.UI;

import org.testng.annotations.Test;
import tests.base.BaseTest;


public class BookStoreTest extends BaseTest {

    @Test
    public void testOfBookStore() {
        pageManager.getLoginPage().open()
                .loginWithCredentials("admin6", "Password123!")
                .isLoginSuccessful()
                .moveToBookStore()
                .useSearch("Programming JavaScript Applications");
    }
}
