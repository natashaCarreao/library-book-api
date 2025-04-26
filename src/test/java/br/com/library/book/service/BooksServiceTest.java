package br.com.library.book.service;

import br.com.library.book.dto.BookDTO;
import br.com.library.data.sync.reposiory.BookRepository;
import br.com.library.infra.model.document.AuthorDocument;
import br.com.library.infra.model.document.BookDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

class BooksServiceTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BooksService booksService;

    /*@BeforeEach
    void before(){
        //reset(bookRepository);
    }*/

    @Test
    void getAll() {

        List<AuthorDocument> mockAuthors = new ArrayList<>();
        mockAuthors.add(new AuthorDocument("author name"));

        List<BookDocument> mockBooks = new ArrayList<>();
        var mockBook = new BookDocument("Book title", "Terror", 2023, 600, mockAuthors);
        mockBooks.add(mockBook);

        when(bookRepository.findAll()).thenReturn(mockBooks);
        var books = booksService.getAll();

        assertFalse(books.isEmpty());

        var expectedResult = BookDTO.BooksDocumentToBooksDto(mockBooks);
        assertEquals(expectedResult.size(), books.size());
    }

    @Test
    void getById() {
    }

    @Test
    void getByGenre() {
    }

    @Test
    void getByAuthor() {
    }

    @Test
    void delete() {
    }
}