package br.com.library.data.book.document;

import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@Document(indexName = "book")
public class BookDocument {

    public BookDocument(String title, String isb, String genre, Integer yearRelease, Integer numberPages,
                        @Nonnull List<AuthorDocument> authors) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.isb = isb;
        this.genre = genre;
        this.yearRelease = yearRelease;
        this.numberPages = numberPages;
        this.authors = authors;
    }

    @Id
    private String id;

    private String title;

    private String isb;
    private String genre;


    private Integer yearRelease;

    private Integer numberPages;

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

    public String getIsb() {
        return isb;
    }

    public void setIsb(String isb) {
        this.isb = isb;
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

    @Override
    public String toString() {
        return "BookDocument{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", isb='" + isb + '\'' +
                ", genre='" + genre + '\'' +
                ", yearRelease=" + yearRelease +
                ", numberPages=" + numberPages +
                ", authors=" + authors +
                '}';
    }
}
