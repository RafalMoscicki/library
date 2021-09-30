package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class RentalDto {

    private long id;
    private Exemplar exemplar;
    private User user;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
