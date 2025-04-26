package br.com.library.data.sync.initialize;


import br.com.library.data.sync.client.OpenLibraryClient;
import br.com.library.book.service.IBooksService;
import br.com.library.data.sync.service.SyncBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializeDataBook implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(InitializeDataBook.class);

    private final OpenLibraryClient openLibraryClient;

    private final SyncBookService bookService;

    @Autowired
    public InitializeDataBook(OpenLibraryClient openLibraryClient, SyncBookService bookService) {
        this.openLibraryClient = openLibraryClient;
        this.bookService = bookService;
    }

    void InitializeDataElasticSearch(){
        log.info("Data sync Open Library Api start");
        var booksResponse = openLibraryClient.getAllBooks();
        bookService.saveAll(booksResponse.buildBooksDTO());
        log.info("Data sync Open Library Api finish");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        InitializeDataElasticSearch();
    }
}
