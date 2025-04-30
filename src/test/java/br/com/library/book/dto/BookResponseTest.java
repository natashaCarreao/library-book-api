package br.com.library.book.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookResponseTest {

    private final String dateMock = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss"));

    @Test
    void newBookResponse() {

        var listAuthorsName = new String[]{"John", "Luis"};
        var bookResponse = new BookResponse("id", "title", "Terror", Arrays.stream(listAuthorsName).toList(),
                2020, 1000, dateMock);

        assertNotNull(bookResponse);
        assertEquals(bookResponse.getAuthors(), Arrays.stream(listAuthorsName).toList());
        assertNotNull(bookResponse.getYearRelease());
        assertEquals(dateMock,bookResponse.getCreatedAt());
        assertNotNull(bookResponse.getNumberPages());
        assertNotNull(bookResponse.getId());
        assertNotNull(bookResponse.getGenre());
        assertNotNull(bookResponse.getTitle());


        listAuthorsName = new String[]{"Luis"};
        bookResponse.setAuthors(Arrays.stream(listAuthorsName).toList());
        bookResponse.setId("_id");
        bookResponse.setTitle("New Title");
        bookResponse.setGenre("xxxx");
        bookResponse.setYearRelease(2021);
        bookResponse.setNumberPages(300);
        bookResponse.setCreatedAt(dateMock);

        assertEquals(bookResponse.getAuthors(), Arrays.stream(listAuthorsName).toList());
        assertEquals("_id", bookResponse.getId());
        assertEquals("New Title", bookResponse.getTitle());
        assertEquals("xxxx", bookResponse.getGenre());
        assertEquals(2021, bookResponse.getYearRelease());
        assertEquals(300, bookResponse.getNumberPages());
        assertEquals(dateMock, bookResponse.getCreatedAt());
    }
}
