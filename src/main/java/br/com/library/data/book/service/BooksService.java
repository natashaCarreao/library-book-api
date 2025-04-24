package br.com.library.data.book.service;

import br.com.library.data.book.document.AuthorDocument;
import br.com.library.data.book.document.BookDocument;
import br.com.library.data.book.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class BooksService implements IBooksService {
    private  static final Logger log = LoggerFactory.getLogger(BooksService.class);
    private final BookRepository bookRepository;

    @Autowired
    public BooksService(BookRepository  bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBook() {

        var authors = new ArrayList<AuthorDocument>();
        authors.add(new AuthorDocument("name author"));
        var id = bookRepository.save(new BookDocument("title","isb", "genre", 2025,
                52, authors));

        log.info("teste de save document: {{}}", id.getId());
    }

    @Override
    public void getAll() {
        var listAllBook = bookRepository.findAll();
        listAllBook.forEach((l) ->  log.info("test get all: {{}} {{}} {{}} {{}} {{}} " +
                        "list author: {{}}",l.getId(),l.getTitle(),l.getIsb(),l.getGenre(),
                l.getNumberPages(), l.getAuthors()));

    }
}
