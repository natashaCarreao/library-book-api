package br.com.library.book.controller;

import br.com.library.book.dto.BookResponse;
import br.com.library.book.dto.LibraryBookResponse;
import org.springframework.http.ResponseEntity;

public interface IBookController {

    ResponseEntity<Boolean> healthApi();
    ResponseEntity<LibraryBookResponse> getAll();

    ResponseEntity<BookResponse> getByID(String id);

    ResponseEntity<LibraryBookResponse> getByGenre(String genre);

    ResponseEntity<LibraryBookResponse> getByAuthor(String genre);

}
