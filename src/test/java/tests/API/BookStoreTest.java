package tests.API;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseApiTest;

public class BookStoreTest extends BaseApiTest {

    @Test(description = "Получение списка всех книг")
    public void testGetBooks() {
        Response response = bookStoreService.getBooks();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("books").size() > 0);
    }

    @Test(description = "Добавление книги в коллекцию")
    public void testAddBook() {
        String isbn = bookStoreService.getBooks().jsonPath().getString("books[0].isbn");

        bookStoreService.deleteAllBooks(userId, token);

        Response response = bookStoreService.addBook(userId, isbn, token);
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(description = "Удаление всех книг из коллекции")
    public void testDeleteBooks() {
        Response response = bookStoreService.deleteAllBooks(userId, token);
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}