package br.com.library.book.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryBookResponseTest {

    @Test
    void newLibraryBookTest(){

        List<BookResponse> listBook = new ArrayList<>();

        var libraryResponse = new LibraryBookResponse();
        libraryResponse.setBooks(listBook);
        libraryResponse.setTotalItems(0);

        assertEquals(libraryResponse.getTotalItems(), 0);
        assertEquals(libraryResponse.getBooks(), listBook);

        libraryResponse = new LibraryBookResponse(listBook);
        assertEquals(libraryResponse.getTotalItems(), 0);
        assertEquals(libraryResponse.getBooks(), listBook);
    }
}
