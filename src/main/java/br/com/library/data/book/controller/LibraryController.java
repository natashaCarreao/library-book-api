package br.com.library.data.book.controller;

import br.com.library.data.book.dto.BookDTO;
import br.com.library.data.book.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    @GetMapping("books")
    public ResponseEntity<List<BookDTO>> getAll() {
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }


    @DeleteMapping("delete-all")
    public ResponseEntity<Boolean> deleteAll(){
        bookService.delete();
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}


