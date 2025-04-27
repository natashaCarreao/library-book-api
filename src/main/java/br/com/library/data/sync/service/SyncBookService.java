package br.com.library.data.sync.service;

import br.com.library.book.service.BooksService;
import br.com.library.data.sync.dto.BookDTO;
import br.com.library.data.sync.reposiory.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SyncBookService {
    private  static final Logger log = LoggerFactory.getLogger(BooksService.class);

    private final BookRepository bookRepository;

    @Autowired
    public SyncBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveAll(List<BookDTO> booksToInsert) {
        bookRepository.saveAll(booksToInsert.stream().map(BookDTO::buildBookDocument).collect(Collectors.toList()));
        log.info("Save all books success full");
    }
}
