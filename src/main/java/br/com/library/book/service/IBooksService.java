package br.com.library.book.service;

import br.com.library.book.dto.BookDTO;

import java.util.List;

public interface IBooksService {
    List<BookDTO> getAll() throws Exception ;

    BookDTO getById(String id) throws Exception ;

    List<BookDTO> getByGenre(String genre) throws Exception ;

    List<BookDTO> getByAuthor(String authorName) throws Exception ;
    void delete();
}
