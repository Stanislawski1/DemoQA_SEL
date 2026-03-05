package tests.base;


import config.ProjectConfig;
import api.models.Credentials;
import api.services.AccountService;
import api.services.BookStoreService;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseApiTest {

    protected static ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    protected AccountService accountService = new AccountService();
    protected BookStoreService bookStoreService = new BookStoreService();
    protected Logger logger = LoggerFactory.getLogger(BaseApiTest.class);

    protected String token;
    protected String userId;

    @BeforeClass
    public void setUpApi(ITestContext context) {

        Credentials credentials = new Credentials(config.username(), config.password());

        var loginRes = accountService.login(credentials);
        logger.info("Login response: {}", loginRes.asString());
        userId = loginRes.jsonPath().getString("userId");

        var tokenRes = accountService.generateToken(credentials);
        token = tokenRes.jsonPath().getString("token");
        logger.info("Token response: {}", tokenRes.asString());

        if (token == null || userId == null) {
            throw new RuntimeException("API Setup failed! Check config.properties or server availability.");
        }
    }
}