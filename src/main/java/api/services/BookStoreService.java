package api.services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BookStoreService {
    private final String BASE_URL = "https://demoqa.com";

    public Response getBooks() {
        return given()
                .get(BASE_URL + "/BookStore/v1/Books");
    }

    public Response addBook(String userId, String isbn, String token) {
        String body = "{"
                + "\"userId\": \"" + userId + "\","
                + "\"collectionOfIsbns\": [{\"isbn\": \"" + isbn + "\"}]"
                + "}";

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(body)
                .post(BASE_URL + "/BookStore/v1/Books");
    }

    public Response deleteAllBooks(String userId, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .queryParam("UserId", userId)
                .delete(BASE_URL + "/BookStore/v1/Books");
    }

    public Response getBookByIsbn(String isbn) {
        return given()
                .queryParam("ISBN", isbn)
                .get(BASE_URL + "/BookStore/v1/Book");
    }
}