package br.com.library.data.book.controller;

import br.com.library.data.book.dto.BookDTO;
import br.com.library.data.book.dto.BookResponse;
import br.com.library.data.book.dto.LibraryBookResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ILibrary {

    ResponseEntity<Boolean> healthApi();
    ResponseEntity<LibraryBookResponse> getAll();

    ResponseEntity<BookResponse> getByID(String id);

    ResponseEntity<LibraryBookResponse> getByGenre(String genre);

    ResponseEntity<LibraryBookResponse> getByAuthor(String genre);

}
