package br.com.library.book.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookWorkResponse {

    @JsonProperty("work")
    private BookResponse book;

    public BookResponse getBook() {
        return book;
    }

    public void setBook(BookResponse book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookOpenLibraryResponse{" +
                "book=" + book +
                '}';
    }
}
