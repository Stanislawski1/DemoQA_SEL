package tests.base;


import api.config.ProjectConfig;
import api.models.Credentials;
import api.services.AccountService;
import api.services.BookStoreService;
import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseApiTest {

    protected static ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    protected AccountService accountService = new AccountService();
    protected BookStoreService bookStoreService = new BookStoreService();

    protected String token;
    protected String userId;

    @BeforeClass
    public void setUpApi(ITestContext context) {

        Credentials credentials = new Credentials(config.username(), config.password());

        var loginRes = accountService.login(credentials);
        userId = loginRes.jsonPath().getString("userId");

        var tokenRes = accountService.generateToken(credentials);
        token = tokenRes.jsonPath().getString("token");

        if (token == null || userId == null) {
            throw new RuntimeException("API Setup failed! Check config.properties or server availability.");
        }
    }
}