package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.awt.print.Book;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookListResponse {
    private List<Book> books;
}
