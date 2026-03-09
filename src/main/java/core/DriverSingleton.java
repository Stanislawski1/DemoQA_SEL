package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
    public static WebDriver driver;

    private DriverSingleton() {

    }

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--headless");

                    driver = new ChromeDriver(options);
                    break;
                default:
                    driver = new ChromeDriver();
            }
            driver.manage().window().setSize(new Dimension(1920, 1080));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

