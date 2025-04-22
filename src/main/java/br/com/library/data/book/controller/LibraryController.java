package br.com.library.data.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LibraryController implements ILibrary{

    @GetMapping("health")
    public ResponseEntity<Boolean> healthApi() {
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
