package tests.steps;

import manager.PageManager;
import org.openqa.selenium.WebDriver;


public class ElementsSteps {

    PageManager pageManager;
    protected WebDriver driver;

    public ElementsSteps(WebDriver driver) {
        this.driver = driver;
        this.pageManager = new PageManager(driver);
    }

    public void goToElements() {
        pageManager.getMainPage().open()
                .isPageOpened()
                .moveToElements();
    }
}
