package br.com.library.data.book.document;

import br.com.library.data.book.dto.BookDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document(indexName = "book")
public class BookDocument {

    public BookDocument(String title, String isb, String genre, Integer yearRelease, Integer numberPages,
                        @Nonnull List<AuthorDocument> authors) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.genre = genre;
        this.yearRelease = yearRelease;
        this.numberPages = numberPages;
        this.authors = authors;
    }

    public BookDocument(BookDTO bookDTO){
        this.id = UUID.randomUUID().toString();
        this.title = bookDTO.getTitle();
        this.genre = bookDTO.getGenre();
        this.yearRelease = bookDTO.getYearRelease();
        this.numberPages = bookDTO.getNumberPages();
        this.authors = bookDTO.getAuthors().stream()
                .map(AuthorDocument::new).collect(Collectors.toList());
    }

    public BookDocument(){
    }

    @Id
    private String id;

    private String title;

    private String genre;

    @Field(type = FieldType.Integer, name = "year_release")
    private Integer yearRelease;

    @Field(type = FieldType.Integer, name = "number_pages")
    private Integer numberPages;

    //@JsonProperty("created_at")
    @Field(type = FieldType.Date, format = { }, pattern = "yyyy-MM-dd'T'HH:mm:ss", name = "created_at")
    private String createdAt;

    @Field(type = FieldType.Date, format = { }, pattern = "yyyy-MM-dd'T'HH:mm:ss", name = "updated_at")
    private LocalDate updatedAt;

    @Nonnull
    private List<AuthorDocument> authors;

    public String getId() {
        return id;
    }

    public String getGenre() {
        return genre;
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

    @Nonnull
    public List<AuthorDocument> getAuthors() {
        return authors;
    }

    public void setAuthors(@Nonnull List<AuthorDocument> authors) {
        this.authors = authors;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BookDocument{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", yearRelease=" + yearRelease +
                ", numberPages=" + numberPages +
                ", authors=" + authors +
                '}';
    }
}
