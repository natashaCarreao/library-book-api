package br.com.library.data.book.config;


import br.com.library.data.book.client.OpenLibraryClient;
import br.com.library.data.book.service.BooksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class InitializeDataBook implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(InitializeDataBook.class);

    private final OpenLibraryClient openLibraryClient;

    @Autowired
    public InitializeDataBook(OpenLibraryClient openLibraryClient) {
        this.openLibraryClient = openLibraryClient;
    }

    void InitializeDataElasticSearch(){
        var tst = openLibraryClient.getAllBooks();
        log.info("return books: {{}} {{}}", tst.getBooks().get(0).getBook().getAuthorsNames(), GenreEnum.RANDON.generateAleatoryGenre());
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(" teste executation");
        InitializeDataElasticSearch();
    }
}
