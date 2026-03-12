package tests.base;

import api.models.Credentials;
import api.services.AccountService;
import api.services.BookStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.TestListener;
import utils.property.PropertyConfig;

@Listeners(TestListener.class)
public class BaseApiTest {

    protected AccountService accountService = new AccountService();
    protected BookStoreService bookStoreService = new BookStoreService();
    protected Logger logger = LoggerFactory.getLogger(BaseApiTest.class);

    protected String token;
    protected String userId;

    @BeforeClass
    public void setUpApi(ITestContext context) {
        logger.info("Setting up API credentials...");

        String user = PropertyConfig.getApiUsername();
        String pass = PropertyConfig.getApiPassword();

        Credentials credentials = new Credentials(user, pass);

        var loginRes = accountService.login(credentials);
        userId = loginRes.jsonPath().getString("userId");

        var tokenRes = accountService.generateToken(credentials);
        token = tokenRes.jsonPath().getString("token");

        if (token == null || userId == null) {
            logger.error("API Login failed for user: {}", user);
            throw new RuntimeException("API Setup failed! Check config.properties or server availability.");
        }
        logger.info("API Setup successful. UserID: {}", userId);

        context.setAttribute("token", token);
    }
}