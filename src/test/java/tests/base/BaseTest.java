package tests.base;



import manager.PageManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ui.pages.Login.LoginPage;
import utils.TestListener;


import java.time.Duration;
import java.util.HashMap;

@Listeners({TestListener.class})
public abstract class BaseTest {

    protected WebDriver driver;

    protected PageManager pageManager;


    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito", "--disable-notifications",
                    "--disable-popup-blocking", "--disable-infobars");
//            if (System.getProperty("headless", "true").equals("true")) {
//                options.addArguments("--headless");
//            }
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");

            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("--private");
            options.addPreference("dom.webnotifications.enabled", false);
            driver = new FirefoxDriver(options);
        }

        pageManager = new PageManager(driver);


        context.setAttribute("driver", driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
