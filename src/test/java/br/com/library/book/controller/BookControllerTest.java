package br.com.library.book.controller;

import br.com.library.book.dto.BookDTO;
import br.com.library.book.service.BooksService;
import br.com.library.book.service.CacheService;
import br.com.library.book.service.IBooksService;
import br.com.library.book.service.ICacheService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

public class BookControllerTest {

    private final IBooksService booksService = Mockito.mock(BooksService.class);

    private final ICacheService cacheService = Mockito.mock(CacheService.class);

    private final IBookController bookController = new BookController(booksService, cacheService);

    @BeforeEach
    void before(){
        reset(booksService);
    }

    @Test
    void getAllBooksSuccess() throws Exception {

        var bookDTO = makeMockBookDTO();

        List<BookDTO> bookDTOList = new ArrayList<>();
        bookDTOList.add(bookDTO);

        when(booksService.getAll()).thenReturn(bookDTOList);
        var bookResponse = bookController.getAll();

        assertEquals(HttpStatus.OK, bookResponse.getStatusCode());
        assertEquals(bookDTOList.size(), bookResponse.getBody().getBooks().size());
        assertEquals(bookDTOList.getFirst().getGenre(), bookResponse.getBody().getBooks().getFirst().getGenre());
        assertEquals(bookDTOList.getFirst().getCreatedAt(), bookResponse.getBody().getBooks().getFirst().getCreatedAt());

    }

    @Test
    void getAllBooksError() throws Exception {

        when(booksService.getAll()).thenThrow(new Exception());

        try {
            bookController.getAll();
        }catch (Exception e ){
            assertNotNull(e);
        }
    }

    @Test
    void getBookByIdSuccess() throws Exception {

        var bookId = "book id";
        var bookDTO = makeMockBookDTO();

        when(booksService.getById(bookId)).thenReturn(bookDTO);
        var bookResponse = bookController.getByID(bookId);

        assertEquals(HttpStatus.OK, bookResponse.getStatusCode());
        assertEquals(bookDTO.getGenre(), bookResponse.getBody().getGenre());
        assertEquals(bookDTO.getCreatedAt(), bookResponse.getBody().getCreatedAt());
        assertEquals(bookDTO.getId(), bookResponse.getBody().getId());
        assertEquals(bookDTO.getTitle(), bookResponse.getBody().getTitle());
        assertEquals(bookDTO.getNumberPages(), bookResponse.getBody().getNumberPages());
        assertEquals(bookDTO.getYearRelease(), bookResponse.getBody().getYearRelease());

    }

    @Test
    void getBooksByIdError() throws Exception {

        when(booksService.getById("id")).thenThrow(new Exception());

        try {
            bookController.getAll();
        }catch (Exception e ){
            assertNotNull(e);
        }
    }

    @Test
    void getBookByGenreSuccess() throws Exception {

        var bookGenre = "Terror";
        var bookDTO = makeMockBookDTO();

        List<BookDTO> bookDTOList = new ArrayList<>();
        bookDTOList.add(bookDTO);

        when(booksService.getByGenre(bookGenre)).thenReturn(bookDTOList);
        var bookResponse = bookController.getByGenre(bookGenre);

        assertEquals(HttpStatus.OK, bookResponse.getStatusCode());
        assertEquals(bookDTO.getGenre(), bookResponse.getBody().getBooks().getFirst().getGenre());
        assertEquals(bookDTO.getCreatedAt(), bookResponse.getBody().getBooks().getFirst().getCreatedAt());
        assertEquals(bookDTO.getId(), bookResponse.getBody().getBooks().getFirst().getId());
        assertEquals(bookDTO.getTitle(), bookResponse.getBody().getBooks().getFirst().getTitle());
        assertEquals(bookDTO.getNumberPages(), bookResponse.getBody().getBooks().getFirst().getNumberPages());
        assertEquals(bookDTO.getYearRelease(), bookResponse.getBody().getBooks().getFirst().getYearRelease());

    }

    @Test
    void getBooksByGenreError() throws Exception {

        when(booksService.getByGenre("genre")).thenThrow(new Exception());

        try {
            bookController.getByGenre("genre");
        }catch (Exception e ){
            assertNotNull(e);
        }
    }

    @Test
    void getBookByAuthorNameSuccess() throws Exception {

        var authorName = "John";
        var bookDTO = makeMockBookDTO();

        List<BookDTO> bookDTOList = new ArrayList<>();
        bookDTOList.add(bookDTO);

        when(booksService.getByAuthor(authorName)).thenReturn(bookDTOList);
        var bookResponse = bookController.getByAuthor(authorName);

        assertEquals(HttpStatus.OK, bookResponse.getStatusCode());
        assertEquals(bookDTO.getGenre(), bookResponse.getBody().getBooks().getFirst().getGenre());
        assertEquals(bookDTO.getCreatedAt(), bookResponse.getBody().getBooks().getFirst().getCreatedAt());
        assertEquals(bookDTO.getId(), bookResponse.getBody().getBooks().getFirst().getId());
        assertEquals(bookDTO.getTitle(), bookResponse.getBody().getBooks().getFirst().getTitle());
        assertEquals(bookDTO.getNumberPages(), bookResponse.getBody().getBooks().getFirst().getNumberPages());
        assertEquals(bookDTO.getYearRelease(), bookResponse.getBody().getBooks().getFirst().getYearRelease());

    }

    @Test
    void getBooksByAuthorNameError() throws Exception {

        when(booksService.getByAuthor("author name")).thenThrow(new Exception());

        try {
            bookController.getByGenre("author name");
        }catch (Exception e ){
            assertNotNull(e);
        }
    }

    private BookDTO makeMockBookDTO(){

        var mockDate = LocalDateTime.now();

        var bookDTO = new BookDTO();
        bookDTO.setTitle("Title");
        bookDTO.setGenre("Terror");
        bookDTO.setNumberPages(3000);
        bookDTO.setYearRelease(mockDate.getYear());
        bookDTO.setCreatedAt(mockDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss")));

        return bookDTO;
    }

}
