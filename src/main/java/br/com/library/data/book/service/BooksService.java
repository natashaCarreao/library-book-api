package br.com.library.data.book.service;

import br.com.library.data.book.document.AuthorDocument;
import br.com.library.data.book.document.BookDocument;
import br.com.library.data.book.dto.BookDTO;
import br.com.library.data.book.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService implements IBooksService {
    private  static final Logger log = LoggerFactory.getLogger(BooksService.class);
    private final BookRepository bookRepository;

    @Autowired
    public BooksService(BookRepository  bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveAll(List<BookDTO> booksToInsert) {
        var booksSaved = bookRepository.saveAll(booksToInsert.stream().map(
                book -> {
                    var bookDocument =  new BookDocument(book);
                    bookDocument.setCreatedAt(LocalDateTime.now().format(
                            DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")
                    ));
                    return bookDocument;
                }
        ).collect(Collectors.toList()));

        log.info("Save all books success full");
    }

    @Override
    public List<BookDTO> getAll() {
        List<BookDTO> allBooks = new ArrayList<>();

        var listAllBook = bookRepository.findAll();
        listAllBook.iterator().forEachRemaining (
                (l) -> allBooks.add(
                        new BookDTO(
                                l.getTitle(), l.getAuthors().stream().map(
                                        AuthorDocument::getName
                                ).collect(Collectors.toList()),l.getGenre(),l.getYearRelease(), l.getNumberPages()
                        )
                ));

        return allBooks;
    }
    
    @Override
    public void delete() {
        bookRepository.deleteAll();
    }
}
