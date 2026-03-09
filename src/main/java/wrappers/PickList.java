package wrappers;

import elements.base.BaseElements;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PickList extends BaseElements {

    public PickList(WebDriver driver, String label) {
        super(driver, By.xpath("//label[text()='" + label + "']//following::div[contains(@class,'placeholder')]"));
    }

    public void select(String option) {
        click();
        WebElement optionElement = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class,'menu')]//div[text()='" + option + "']")
                ));
        optionElement.click();
    }
}
