package br.com.library.data.book.document;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;
//@Document(indexName = "author")
public class AuthorDocument {

    public AuthorDocument(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AuthorDocument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
