package com.crud.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity(name = "books")
public class Book {

    public Book(long id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String author;

    private int year;

    @OneToMany(mappedBy = "book",
            targetEntity = Exemplar.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Exemplar> exemplars = new ArrayList<>();

    public void addExemplar(Exemplar exemplar) {
        exemplars.add(exemplar);
        exemplar.setBook(this);
    }
}
