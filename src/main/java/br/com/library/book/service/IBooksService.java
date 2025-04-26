package br.com.library.book.service;

import br.com.library.book.dto.BookDTO;

import java.util.List;

public interface IBooksService {
    List<BookDTO> getAll();

    BookDTO getById(String id);

    List<BookDTO> getByGenre(String genre);

    List<BookDTO> getByAuthor(String authorName);
    void delete();
}
