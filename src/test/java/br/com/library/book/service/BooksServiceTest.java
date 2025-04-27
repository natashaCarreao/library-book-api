package br.com.library.book.service;

import br.com.library.book.dto.BookDTO;
import br.com.library.book.repository.BookRepository;
import br.com.library.infra.model.document.AuthorDocument;
import br.com.library.infra.model.document.BookDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

class BooksServiceTest {

    private final BookRepository bookRepository = Mockito.mock(BookRepository.class);
    private final BooksService booksService  = new BooksService(bookRepository);

    @BeforeEach
    void before(){
        reset(bookRepository);
    }

    @Test
    void getAll() throws Exception {
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
    void getById() throws Exception {
        List<AuthorDocument> mockAuthors = new ArrayList<>();
        mockAuthors.add(new AuthorDocument("author name"));
        var mockBook = new BookDocument("Book title", "Terror", 2023, 600, mockAuthors);

        when(bookRepository.findById(UUID.fromString(mockBook.getId()))).thenReturn(Optional.of(mockBook));
        var book = booksService.getById(mockBook.getId());

        assertEquals(mockBook.getId(), book.getId());
        assertEquals(mockBook.getAuthors().size(), book.getAuthors().size());
        assertEquals(mockBook.getCreatedAt(), book.getCreatedAt());
        assertEquals(mockBook.getTitle(), book.getTitle());
        assertEquals(mockBook.getGenre(), book.getGenre());
        assertEquals(mockBook.getNumberPages(), book.getNumberPages());
        assertEquals(mockBook.getYearRelease(), book.getYearRelease());

    }

    @Test
    void getByGenre() throws Exception {
        List<AuthorDocument> mockAuthors = new ArrayList<>();
        mockAuthors.add(new AuthorDocument("author name"));

        List<BookDocument> mockBooks = new ArrayList<>();
        var mockBook = new BookDocument("Book title", "Terror", 2023, 600, mockAuthors);
        mockBooks.add(mockBook);

        when(bookRepository.findByGenre(mockBook.getGenre())).thenReturn(mockBooks);
        var books = booksService.getByGenre(mockBook.getGenre());

        assertFalse(books.isEmpty());

        var expectedResult = BookDTO.BooksDocumentToBooksDto(mockBooks);
        assertEquals(expectedResult.size(), books.size());
    }

    @Test
    void getByAuthor() throws Exception {

        List<AuthorDocument> mockAuthors = new ArrayList<>();
        mockAuthors.add(new AuthorDocument("author name"));

        List<BookDocument> mockBooks = new ArrayList<>();
        var mockBook = new BookDocument("Book title", "Terror", 2023, 600, mockAuthors);
        mockBooks.add(mockBook);

        when(bookRepository.findByAuthorsName(mockAuthors.getFirst().getName())).thenReturn(mockBooks);
        var books = booksService.getByAuthor(mockAuthors.getFirst().getName());

        assertFalse(books.isEmpty());

        var expectedResult = BookDTO.BooksDocumentToBooksDto(mockBooks);
        assertEquals(expectedResult.size(), books.size());
        assertEquals(expectedResult.getFirst().getAuthors().getFirst(),mockAuthors.getFirst().getName());
    }

    @Test
    void delete() {
    }
}