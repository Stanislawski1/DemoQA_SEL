package manager;

import org.openqa.selenium.WebDriver;
import ui.pages.BookStore.BookStorePage;
import ui.pages.Elements.ElementsPage;
import ui.pages.Login.LoginPage;
import ui.pages.Main.MainPage;


public class PageManager {

    private final WebDriver driver;


    private BookStorePage bookStorePage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ElementsPage elementsPage;
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

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage(driver);
        }
        return mainPage;
    }

    public ElementsPage getElementsPage() {
        if (elementsPage == null) {
            elementsPage = new ElementsPage(driver);
        }
        return elementsPage;
    }
}