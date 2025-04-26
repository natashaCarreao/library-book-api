package br.com.library.data.book.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LibraryBookResponse {

    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("current_page")
    private Integer currentPage;

    @JsonProperty("total_items_page")
    private Integer totalItemsPage;

    private List<BookResponse> books;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalItemsPage() {
        return totalItemsPage;
    }

    public void setTotalItemsPage(Integer totalItemsPage) {
        this.totalItemsPage = totalItemsPage;
    }

    public List<BookResponse> getBooks() {
        return books;
    }

    public void setBooks(List<BookResponse> books) {
        this.books = books;
    }

}
