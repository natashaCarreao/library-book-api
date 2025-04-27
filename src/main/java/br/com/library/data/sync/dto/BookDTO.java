package br.com.library.data.sync.dto;

import br.com.library.infra.model.document.AuthorDocument;
import br.com.library.infra.model.document.BookDocument;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BookDTO {


    public BookDTO(String id, String title, List<String> authors, String genre, Integer yearRelease, Integer numberPages, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.genre = genre;
        this.yearRelease = yearRelease;
        this.numberPages = numberPages;
        this.createdAt = createdAt;
    }

    public BookDTO(){};

    private String id;

    private String title;
    private List<String> authors;

    private String genre;


    private Integer yearRelease;


    private Integer numberPages;

    private LocalDateTime createdAt;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BookDocument buildBookDocument(){
        return new BookDocument(
                this.title,
                this.genre,
                this.yearRelease,
                this.numberPages,
                this.authors.stream().map(AuthorDocument::new).collect(Collectors.toList()));
    }
}


