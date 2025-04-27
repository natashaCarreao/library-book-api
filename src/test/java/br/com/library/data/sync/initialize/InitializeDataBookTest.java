package br.com.library.data.sync.initialize;

import br.com.library.DataBookApiApplication;
import br.com.library.data.sync.client.OpenLibraryClient;
import br.com.library.data.sync.dto.BookResponse;
import br.com.library.data.sync.dto.BookWorkResponse;
import br.com.library.data.sync.dto.OpenLibraryResponse;
import br.com.library.data.sync.service.SyncBookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.ApplicationArguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class InitializeDataBookTest {

    private final OpenLibraryClient openLibraryClient = Mockito.mock(OpenLibraryClient.class);

    private final SyncBookService syncBookService =  Mockito.mock(SyncBookService.class);

    private final InitializeDataBook initialize = new InitializeDataBook(openLibraryClient, syncBookService);

    @BeforeEach
    void before(){
        reset(openLibraryClient);
        reset(syncBookService);
    }

    @Test
    void testRun() throws Exception {

        var listAuthorsName = new String[]{"Luis"};

        var bookResponse = new BookResponse();
        bookResponse.setTitle("New Book");
        bookResponse.setAuthorsNames(Arrays.stream(listAuthorsName).toList());
        bookResponse.setYearOfRelease(2020);

        var bookWork = new BookWorkResponse();
        bookWork.setBook(bookResponse);

        List<BookWorkResponse> bookWorkResponses = new ArrayList<>();
        bookWorkResponses.add(bookWork);

        var openLibraryResponse = new OpenLibraryResponse();
        openLibraryResponse.setBooks(bookWorkResponses);

        when(openLibraryClient.getAllBooks()).thenReturn(openLibraryResponse);
        doNothing().when(syncBookService).saveAll(any());

        initialize.InitializeDataElasticSearch();

        verify(syncBookService,Mockito.times(1)).saveAll(any());


    }
}
