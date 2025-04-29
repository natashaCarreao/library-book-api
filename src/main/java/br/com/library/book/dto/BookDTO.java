package br.com.library.book.dto;

import br.com.library.infra.model.document.AuthorDocument;
import br.com.library.infra.model.document.BookDocument;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonDeserialize
@JsonSerialize
public class BookDTO {

    public BookDTO(String id, String title,List<String> authors, String genre, Integer yearRelease, Integer numberPages, String createdAt) {
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

    @JsonIgnore
    private List<String> authors;

    private String genre;

    private Integer yearRelease;

    private Integer numberPages;

    private String createdAt;

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public static List<BookDTO> BooksDocumentToBooksDto(Iterable<BookDocument> books) {

        List<BookDTO> bookDTOS = new ArrayList<>();
        books.iterator().forEachRemaining (bookDto ->
            bookDTOS.add(new BookDTO(bookDto.getId(),
                    bookDto.getTitle(),
                    bookDto.getAuthors().stream().map(
                            AuthorDocument::getName
                    ).collect(Collectors.toList()),
                    bookDto.getGenre(), bookDto.getYearRelease(),
                    bookDto.getNumberPages(),
                    bookDto.getCreatedAt()))
            );

        return bookDTOS;

    }
}


