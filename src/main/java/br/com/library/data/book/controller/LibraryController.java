package br.com.library.data.book.controller;

import br.com.library.data.book.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
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

    @GetMapping("test")
    public ResponseEntity<Boolean> test() {
        bookService.saveBook();
        bookService.getAll();
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
