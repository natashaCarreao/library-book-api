package br.com.library.book.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookResponse {

    private String id;

    private String title;

    private String genre;

    private List<String> authors;

    @JsonProperty("year_release")
    private Integer yearRelease;

    @JsonProperty("number_pages")
    private Integer numberPages;

    @JsonProperty("created_at")
    private String createdAt;

    public BookResponse(String id, String title, String genre, List<String> authors, Integer yearRelease,
                        Integer numberPages, String createdAt) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.authors = authors;
        this.yearRelease = yearRelease;
        this.numberPages = numberPages;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Integer getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(Integer yearRelease) {
        this.yearRelease = yearRelease;
    }

    public Integer getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(Integer numberPages) {
        this.numberPages = numberPages;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public static BookResponse bookDTOToBookResponse(BookDTO bookDTO) {
        return new BookResponse(bookDTO.getId(), bookDTO.getTitle(),bookDTO.getGenre(), bookDTO.getAuthors(),
                 bookDTO.getYearRelease(), bookDTO.getNumberPages(), bookDTO.getCreatedAt());
    }

    public static List<BookResponse> booksDTOToBooksResponse(List<BookDTO> booksDto){
        return  booksDto.stream().map(BookResponse::bookDTOToBookResponse).toList();
    }
}
