package tests.UI;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.property.PropertyConfig;


public class BookStoreTest extends BaseTest {

    @Test(description = "Проверка страницы Book Store")
    public void testOfBookStore() {
        pageManager.getLoginPage().open()
                .loginWithCredentials(PropertyConfig.getApiUsername(), PropertyConfig.getApiPassword())
                .checkLoginSuccessful()
                .moveToBookStore()
                .useSearchNCheck("Programming JavaScript Applications");
    }
}
