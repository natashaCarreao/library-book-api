package br.com.library.common.exception;

import br.com.library.book.controller.BookController;
import br.com.library.book.service.BooksService;
import br.com.library.book.service.CacheService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private BooksService booksService;

    @MockitoBean
    private CacheService cacheService;

    @BeforeEach
    void before(){
        reset(booksService);
        reset(cacheService);
    }

    @Test
    public void handleGenericThrowable() throws Exception {

        when(booksService.getAll()).thenThrow(Exception.class);

        var responseErr = mockMvc.perform(MockMvcRequestBuilders
                .get("/books")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isInternalServerError()).andReturn();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), responseErr.getResponse().getStatus());
        assertNotNull(responseErr.getResponse().getContentAsString());
    }
}
