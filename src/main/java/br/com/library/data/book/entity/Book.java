package br.com.library.data.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table
public class Book {

    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    /*@Column(nullable = false)
    private Author author;*/

    @Column(nullable = false)
    private String genre;

    @Column
    private Long yearRelease;

    @Column
    private Long numberPages;
}
