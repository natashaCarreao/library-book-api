package br.com.library.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

}
