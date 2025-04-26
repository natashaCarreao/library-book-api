package br.com.library.data.book.service;

import br.com.library.data.book.dto.BookDTO;

import java.util.List;

public interface IBooksService {

    void saveAll(List<BookDTO> booksToSave);
    List<BookDTO> getAll();

    BookDTO getById(String id);

    List<BookDTO> getByGenre(String genre);

    List<BookDTO> getByAuthor(String authorName);
    void delete();
}
