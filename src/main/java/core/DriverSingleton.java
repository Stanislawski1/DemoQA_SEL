package core;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.property.PropertyConfig;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {
    public static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            // Сначала проверяем системную переменную (из командной строки -Dgrid.url)
            // Если её нет, берем из конфига
            String gridUrl = System.getProperty("grid.url", PropertyConfig.getGridUrl());

            if (gridUrl != null && !gridUrl.isEmpty() && !gridUrl.equals("null")) {
                driver = createRemoteDriver(browser, gridUrl);
            } else {
                driver = createLocalDriver(browser);
            }

            driver.manage().window().setSize(new Dimension(1920, 1080));
        }
        return driver;
    }

    private static WebDriver createLocalDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-popup-blocking");
                // options.addArguments("--headless"); // Пока закомментим, чтобы видеть процесс у кореша
                return new ChromeDriver(options);
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            case "safari":
                return new SafariDriver();
            default:
                return new ChromeDriver();
        }
    }

    private static WebDriver createRemoteDriver(String browser, String gridUrl) {
        try {
            URL url = new URL(gridUrl);
            if (browser.toLowerCase().equals("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless"); // Обязательно для CI
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                return new RemoteWebDriver(url, options);
            } else {
                // Для остальных браузеров (если нужно)
                return new RemoteWebDriver(url, new ChromeOptions());
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error with Selenium Grid URL: " + gridUrl, e);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}