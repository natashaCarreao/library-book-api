package br.com.library.data.sync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookResponse {

    @JsonProperty("title")
    private String title;

    @JsonProperty("author_names")
    private List<String> authorsNames;

    @JsonProperty("first_publish_year")
    private Integer yearOfRelease;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthorsNames() {
        return authorsNames;
    }

    public void setAuthorsNames(List<String> authorsNames) {
        this.authorsNames = authorsNames;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "BookOpenLibraryResponse{" +
                "title='" + title + '\'' +
                ", authorsNames=" + authorsNames +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
