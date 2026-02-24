package services;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Credentials;

import static io.restassured.RestAssured.given;

public class AccountService {

    private final String BASE_URL = "https://demoqa.com";

    public Response login(Credentials authData) {
        return given()
                .contentType(ContentType.JSON)
                .body(authData)
                .post(BASE_URL + "/Account/v1/Login");
    }

    public Response generateToken(Credentials authData) {
        return given()
                .contentType(ContentType.JSON)
                .body(authData)
                .post(BASE_URL + "/Account/v1/GenerateToken");
    }
}