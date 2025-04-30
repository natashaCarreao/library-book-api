package br.com.library.data.sync.dto;

import br.com.library.infra.model.document.BookDocument;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class BookDTOTest {

    @Test
    void newBookDTOTest(){

        var listAuthorsName = new String[]{"Luis"};
        var mockTime = LocalDateTime.now();

        var bookDTO = new BookDTO("id","title", Arrays.stream(listAuthorsName).toList(),"terror",
                2021, 1888, LocalDateTime.now());
        bookDTO.setCreatedAt(mockTime);

        assertEquals(Arrays.stream(listAuthorsName).toList(),bookDTO.getAuthors());
        assertEquals("title", bookDTO.getTitle());
        assertEquals(2021, bookDTO.getYearRelease());
        assertEquals("id", bookDTO.getId());
        assertEquals("terror", bookDTO.getGenre());
        assertEquals(1888, bookDTO.getNumberPages());
        assertEquals(mockTime, bookDTO.getCreatedAt());
        assertInstanceOf(BookDocument.class, bookDTO.buildBookDocument());

    }
}
