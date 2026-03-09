package wrappers;

import elements.base.BaseElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea extends BaseElements {

    public TextArea(WebDriver driver, String label) {
        super(driver, By.xpath("//label[text()='" + label + "']//following::textarea[1]"));
    }

    public void write(String value) {
        findElement().clear();
        findElement().sendKeys(value);
    }
}
