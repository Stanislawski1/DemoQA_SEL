package manager;

import org.openqa.selenium.WebDriver;
import ui.pages.BookStore.BookStorePage;
import ui.pages.Login.LoginPage;


public class PageManager {

    private final WebDriver driver;


    private BookStorePage bookStorePage;
    private LoginPage loginPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }



    public  BookStorePage getBookStorePage() {
        if (bookStorePage == null) {
            bookStorePage = new BookStorePage(driver);
        }
        return bookStorePage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
}