package br.com.library.book.controller;

import br.com.library.book.dto.BookResponse;
import br.com.library.book.dto.LibraryBookResponse;
import br.com.library.book.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("books")
public class BookController implements IBookController {

    private final IBooksService bookService;

    @Autowired
    public BookController(IBooksService bookService) {
        this.bookService = bookService;
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


    @DeleteMapping("delete-all")
    @ResponseBody
    public ResponseEntity<Boolean> deleteAll(){
        bookService.delete();
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}


