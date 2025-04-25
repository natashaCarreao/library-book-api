package br.com.library.data.book.controller;

import br.com.library.data.book.dto.BookDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ILibrary {

    ResponseEntity<Boolean> healthApi();
    ResponseEntity<List<BookDTO>> getAll();

}
