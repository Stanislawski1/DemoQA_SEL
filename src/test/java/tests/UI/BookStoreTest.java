package tests.UI;

import org.testng.annotations.Test;
import tests.base.BaseTest;


public class BookStoreTest extends BaseTest {

    @Test(description = "Проверка страницы Book Store")
    public void testOfBookStore() {
        pageManager.getLoginPage().open()
                .loginWithCredentials("admin6", "Password123!")
                .checkLoginSuccessful()
                .moveToBookStore()
                .useSearchNCheck("Programming JavaScript Applications");
    }
}
