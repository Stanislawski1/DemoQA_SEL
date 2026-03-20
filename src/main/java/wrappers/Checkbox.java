package wrappers;

import elements.base.BaseElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox extends BaseElements {

    public Checkbox(WebDriver driver, String label) {
        super(driver, By.xpath("//li[.//span[contains(@class,'rct-title') and normalize-space()='"+label+"']]//span[contains(@class,'rct-checkbox')]"));
    }

    public void check() {
        if (!findElement().isSelected()) {
            click();
        }
    }

    public void uncheck() {
        if (findElement().isSelected()) {
            click();
        }
    }

    public boolean isChecked() {
        return findElement().isSelected();
    }
}
