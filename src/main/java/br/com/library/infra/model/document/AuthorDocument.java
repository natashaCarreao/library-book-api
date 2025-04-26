package br.com.library.infra.model.document;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.UUID;
public class AuthorDocument {

    public AuthorDocument(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public AuthorDocument(){}

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
