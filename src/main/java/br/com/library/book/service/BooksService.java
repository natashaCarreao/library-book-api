package br.com.library.book.service;

import br.com.library.book.dto.BookDTO;
import br.com.library.book.repository.BookRepository;
import br.com.library.infra.model.document.AuthorDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BooksService implements IBooksService {
    private  static final Logger log = LoggerFactory.getLogger(BooksService.class);
    private final BookRepository bookRepository;

    @Autowired
    BooksService(BookRepository  bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAll() throws Exception {

        var allBooks = BookDTO.BooksDocumentToBooksDto(bookRepository.findAll());
        log.info("Total {{}} books found", allBooks.size());

        return allBooks;
    }
    @Override
    public BookDTO getById(String id) throws Exception {
        var bookDocument = bookRepository.findById(UUID.fromString(id));
        if(bookDocument.isEmpty()){
            return new BookDTO();
        }
        log.info("Book found with id: {{}}", id);

        return new BookDTO(
                bookDocument.get().getId(),
                bookDocument.get().getTitle(),
                bookDocument.get().getAuthors().stream().map(AuthorDocument::getName).toList(),
                bookDocument.get().getGenre(),
                bookDocument.get().getYearRelease(),
                bookDocument.get().getNumberPages(),
                bookDocument.get().getCreatedAt());
    }

    @Override
    public List<BookDTO> getByGenre(String genre) throws Exception {

        var booksByGenre = BookDTO.BooksDocumentToBooksDto(bookRepository.findByGenre(genre));
        log.info("Total {{}} books found by genre {{}}", booksByGenre.size(), genre);

        return booksByGenre;
    }

    @Override
    public List<BookDTO> getByAuthor(String authorName) throws Exception {

        var booksByAuthor = BookDTO.BooksDocumentToBooksDto(bookRepository.findByAuthorsName(authorName));
        log.info("Total {{}} books found by author name {{}}", booksByAuthor.size(), authorName);

        return booksByAuthor;
    }

    @Override
    public void delete() {
        bookRepository.deleteAll();
    }
}
