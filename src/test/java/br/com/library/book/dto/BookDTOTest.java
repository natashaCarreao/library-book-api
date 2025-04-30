package br.com.library.book.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookDTOTest {

    @Test
    void newBookDTO() {
        var listAuthorsName = new String[]{"Luis"};

        var book = new BookDTO();
        book.setTitle("New Title");
        book.setYearRelease(2020);
        book.setAuthors(Arrays.stream(listAuthorsName).toList());

        assertEquals(Arrays.stream(listAuthorsName).toList(),book.getAuthors());
        assertEquals("New Title", book.getTitle());
        assertEquals(2020, book.getYearRelease());

    }
}
