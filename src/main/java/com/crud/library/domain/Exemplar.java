package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "exemplars")
public class Exemplar {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private ExemplarStatus status;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public void setStatus(ExemplarStatus status) {
        this.status = status;
    }
}
