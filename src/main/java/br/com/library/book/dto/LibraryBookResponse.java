package br.com.library.book.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LibraryBookResponse {

    @JsonProperty("total_items")
    private Integer totalItems;

    private List<BookResponse> books;

    public LibraryBookResponse(List<BookResponse> books) {
        this.books = books;
        this.totalItems = books.size();
    }

    public LibraryBookResponse() {
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<BookResponse> getBooks() {
        return books;
    }

    public void setBooks(List<BookResponse> books) {
        this.books = books;
    }


}

