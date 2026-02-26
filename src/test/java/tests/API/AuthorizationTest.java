package tests.API;


import api.models.Credentials;
import api.services.AccountService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTest {
    AccountService accountService = new AccountService();
    Credentials credentials = new Credentials("admin6", "Password123!");

    @Test(description = "Авторизация пользователя")
    public void testLogin() {
        Response response = accountService.login(credentials);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("username"), credentials.getUserName());
    }

    @Test(description = "Генерация токена доступа")
    public void testGenerateToken() {
        Response response = accountService.generateToken(credentials);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getString("token"));
        Assert.assertEquals(response.jsonPath().getString("status"), "Success");
    }
}
