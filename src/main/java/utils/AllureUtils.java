package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureUtils {

    public static void takeScreenshot(WebDriver driver) {
        if (driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment("Screenshot on failure", "image/png", "png", screenshot);
        }
    }
}
