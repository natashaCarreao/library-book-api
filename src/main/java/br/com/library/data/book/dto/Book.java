package br.com.library.data.book.dto;

import java.util.UUID;

public class Book {

    private UUID id;

    /*@Column(nullable = false)
    private Author author;*/

    private String genre;


    private Long yearRelease;


    private Long numberPages;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(Long yearRelease) {
        this.yearRelease = yearRelease;
    }

    public Long getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(Long numberPages) {
        this.numberPages = numberPages;
    }
}
