package br.com.library.data.book.controller;

import br.com.library.data.book.dto.BookDTO;
import br.com.library.data.book.dto.BookResponse;
import br.com.library.data.book.dto.LibraryBookResponse;
import br.com.library.data.book.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.domain.geo.RadiusShape;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("books")
public class LibraryController implements ILibrary{

    private final IBooksService bookService;

    @Autowired
    public LibraryController(IBooksService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("health")
    public ResponseEntity<Boolean> healthApi() {
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<LibraryBookResponse> getAll() {
        var response = new LibraryBookResponse();
        response.setBooks(BookResponse.booksDTOToBooksResponse(bookService.getAll()));
        response.setCurrentPage(0);
        response.setTotalPages(1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookResponse> getByID(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(BookResponse.bookDTOToBookResponse(bookService.getById(id)), HttpStatus.OK);
    }

    @GetMapping("genre/{genre}")
    public ResponseEntity<LibraryBookResponse> getByGenre(@PathVariable(name = "genre") String genre) {
        var response = new LibraryBookResponse();
        response.setBooks(BookResponse.booksDTOToBooksResponse(bookService.getByGenre(genre)));
        response.setCurrentPage(0);
        response.setTotalPages(1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("author/{author_name}")
    public ResponseEntity<LibraryBookResponse> getByAuthor(@PathVariable(name = "author_name")String authorName) {
        var response = new LibraryBookResponse();
        response.setBooks(BookResponse.booksDTOToBooksResponse(bookService.getByAuthor(authorName)));
        response.setCurrentPage(0);
        response.setTotalPages(1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("delete-all")
    public ResponseEntity<Boolean> deleteAll(){
        bookService.delete();
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}


