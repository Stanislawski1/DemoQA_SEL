package wrappers;

import elements.base.BaseElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton extends BaseElements {

    public RadioButton(WebDriver driver, String value) {
        super(driver, By.xpath("//label[text()='" + value + "']"));
    }

    public void select() {
        click();
    }
}
