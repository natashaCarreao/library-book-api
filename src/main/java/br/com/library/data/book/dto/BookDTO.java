package br.com.library.data.book.dto;

import java.util.List;
import java.util.UUID;

public class BookDTO {


    public BookDTO(String title,List<String> authors, String genre, Integer yearRelease, Integer numberPages) {
        this.title = title;
        this.authors = authors;
        this.genre = genre;
        this.yearRelease = yearRelease;
        this.numberPages = numberPages;
    }

    private UUID id;

    private String title;
    private List<String> authors;

    private String genre;


    private Integer yearRelease;


    private Integer numberPages;

    public UUID getId() {
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


}


