package br.com.library.data.sync.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenLibraryResponseTest {

    @Test
    void newOpenLibraryResponse(){

        var bookResponse = new BookResponse();

        List<BookWorkResponse> bookWorkResponseList = new ArrayList<>();
        var bookWorkResponse = new BookWorkResponse();
        bookWorkResponse.setBook(bookResponse);
        bookWorkResponseList.add(bookWorkResponse);

        var openLibraryResponse = new OpenLibraryResponse();
        openLibraryResponse.setBooks(bookWorkResponseList);
        openLibraryResponse.setQtFound(10);
        openLibraryResponse.setPage(2);

        assertEquals(2,openLibraryResponse.getPage());
        assertEquals(bookWorkResponseList.size(),openLibraryResponse.getBooks().size());
        assertEquals("OpenLibraryResponse{page=2, qtdFound=10, books=[BookOpenLibraryResponse{" +
                "book=BookOpenLibraryResponse{title='null', authorsNames=null, yearOfRelease=null}}]}",
                openLibraryResponse.toString());
        assertEquals(1, openLibraryResponse.buildBooksDTO().size());
        assertEquals(10, openLibraryResponse.getQtFound());
    }
}
