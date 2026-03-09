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


@Listeners({TestListener.class})
public abstract class BaseTest {

    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected WebDriver driver;
    protected ElementsSteps elementsSteps;
    protected PageManager pageManager;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        logger.info("Setting up test with browser {}", browser);

        driver = DriverSingleton.getDriver(browser);

        pageManager = new PageManager(driver);
        elementsSteps = new ElementsSteps(driver);
        context.setAttribute("driver", driver);
    }

    @AfterSuite
    public void afterSuite() {
        logger.info("Quitting driver");
        DriverSingleton.quitDriver();
    }
}
