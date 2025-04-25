package br.com.library.data.book.service;

import br.com.library.data.book.dto.BookDTO;

import java.util.List;

public interface IBooksService {

    void saveAll(List<BookDTO> booksToSave);
    List<BookDTO> getAll();

    void delete();
}
