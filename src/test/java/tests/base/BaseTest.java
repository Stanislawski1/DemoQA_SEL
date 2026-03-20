package tests.base;



import core.DriverSingleton;
import manager.PageManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;
import tests.steps.ElementsSteps;
import utils.TestListener;
import utils.property.PropertyConfig;


@Listeners({TestListener.class})
public abstract class BaseTest {

    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected WebDriver driver;
    protected ElementsSteps elementsSteps;
    protected PageManager pageManager;

    @BeforeMethod
    public void setup(@Optional String xmlBrowser, ITestContext context) {
        String browser = (xmlBrowser != null) ? xmlBrowser : PropertyConfig.getBrowser();
        if (browser == null) browser = "chrome";

        logger.info("Starting tests on browser: {}", browser);

        driver = DriverSingleton.getDriver(browser);

        pageManager = new PageManager(driver);
        elementsSteps = new ElementsSteps(driver);
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Quitting driver after method");
        DriverSingleton.quitDriver();
    }
}
