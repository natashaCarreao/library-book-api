package br.com.library.data.book.controller;

import org.springframework.http.ResponseEntity;

public interface ILibrary {

    ResponseEntity<Boolean> healthApi();
    ResponseEntity<Boolean> test();

}
