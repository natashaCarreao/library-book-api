package br.com.library.book.controller;

import br.com.library.book.dto.BookResponse;
import br.com.library.book.dto.LibraryBookResponse;
import br.com.library.book.service.IBooksService;
import br.com.library.book.service.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("books")
public class BookController implements IBookController {

    private final IBooksService bookService;

    private final ICacheService cacheService;

    @Autowired
    public BookController(IBooksService bookService, ICacheService cacheService) {
        this.bookService = bookService;
        this.cacheService = cacheService;
    }

    @GetMapping("health")
    public ResponseEntity<Boolean> healthApi() {
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<LibraryBookResponse> getAll() throws Exception {
        return new ResponseEntity<>(new LibraryBookResponse(BookResponse.booksDTOToBooksResponse(bookService.getAll())),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<BookResponse> getByID(@PathVariable(name = "id") String id) throws Exception  {
        return new ResponseEntity<>(BookResponse.bookDTOToBookResponse(bookService.getById(id)), HttpStatus.OK);
    }

    @GetMapping("genre/{genre}")
    @ResponseBody
    public ResponseEntity<LibraryBookResponse> getByGenre(@PathVariable(name = "genre") String genre) throws Exception {
        return new ResponseEntity<>(new LibraryBookResponse(BookResponse.booksDTOToBooksResponse(bookService.getByGenre(genre))),
                HttpStatus.OK);
    }

    @GetMapping("author/{author_name}")
    @ResponseBody
    public ResponseEntity<LibraryBookResponse> getByAuthor(@PathVariable(name = "author_name")String authorName) throws Exception  {
        return new ResponseEntity<>(new LibraryBookResponse(BookResponse.booksDTOToBooksResponse(bookService.getByAuthor(authorName))),
                HttpStatus.OK);
    }

    @GetMapping("recent")
    @ResponseBody
    public ResponseEntity<String> recentSearches() throws Exception {
        return new ResponseEntity<>(cacheService.getValues().toString(), HttpStatus.OK);
    }
}


