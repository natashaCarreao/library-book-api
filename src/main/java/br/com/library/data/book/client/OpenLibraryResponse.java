package br.com.library.data.book.client;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OpenLibraryResponse {

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
}
