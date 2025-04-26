package br.com.library.book.client;


import br.com.library.book.dto.BookDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class OpenLibraryResponse {

    private static final Integer RANDOM_PAGES = 20000;
    @JsonProperty("page")
    private int page;

    @JsonProperty("numFound")
    private int qtFound;

    @JsonProperty("reading_log_entries")
    private List<BookWorkResponse> books;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getQtFound() {
        return qtFound;
    }

    public void setQtFound(int qtFound) {
        this.qtFound = qtFound;
    }

    public List<BookWorkResponse> getBooks() {
        return books;
    }

    public void setBooks(List<BookWorkResponse> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "OpenLibraryResponse{" +
                "page=" + page +
                ", qtdFound=" + qtFound +
                ", books=" + books +
                '}';
    }

    public List<BookDTO> buildBooksDTO(){
        return this.books.stream().map(wBook ->{

            var bookDTO = new BookDTO();

            bookDTO.setTitle(wBook.getBook().getTitle());
            bookDTO.setAuthors(wBook.getBook().getAuthorsNames());
            bookDTO.setGenre(GenreEnum.generateAleatoryGenre());
            bookDTO.setYearRelease(wBook.getBook().getYearOfRelease());
            bookDTO.setNumberPages(new Random().nextInt(RANDOM_PAGES));

            return bookDTO;
        }).collect(Collectors.toList());
    }
}
