package com.crud.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "exemplar_id")
    private Exemplar exemplar;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate rentDate;
    private LocalDate returnDate;

    public Rental(Exemplar exemplar, User user, LocalDate rentDate) {
        this.exemplar = exemplar;
        this.user = user;
        this.rentDate = rentDate;
    }
}
