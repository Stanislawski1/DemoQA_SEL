package tests.API;


import api.models.Credentials;
import api.services.AccountService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.property.PropertyConfig;

public class AuthorizationTest {
    AccountService accountService = new AccountService();

    @Test(description = "Авторизация пользователя")
    public void testLogin() {
        Response response = accountService.login(new Credentials(PropertyConfig.getApiUsername(), PropertyConfig
                .getApiPassword()));
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("username"), PropertyConfig.getApiUsername());
    }

    @Test(description = "Генерация токена доступа")
    public void testGenerateToken() {
        Response response = accountService.generateToken(new Credentials(PropertyConfig.getApiUsername(),
                PropertyConfig.getApiPassword()));
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getString("token"));
        Assert.assertEquals(response.jsonPath().getString("status"), "Success");
    }
}
