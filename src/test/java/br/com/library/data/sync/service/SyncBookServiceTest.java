package br.com.library.data.sync.service;

import br.com.library.data.sync.dto.BookDTO;
import br.com.library.data.sync.reposiory.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SyncBookServiceTest {

    private final BookRepository bookRepository = Mockito.mock(BookRepository.class);
    private final SyncBookService booksService  = new SyncBookService(bookRepository);

    @BeforeEach
    void before(){
        reset(bookRepository);
    }

    @Test
    void saveAllBooks(){
        var listAuthorsName = new String[]{"Luis"};
        List<BookDTO> mockBooks = new ArrayList<>();
        mockBooks.add(
                new BookDTO("id","title", Arrays.stream(listAuthorsName).toList(),"terror",
                        2023, 500 , LocalDateTime.now()));
        when(bookRepository.saveAll(any())).thenReturn(null);

        booksService.saveAll(mockBooks);

        verify(bookRepository, Mockito.times(1)).saveAll(any());
    }

}
