package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class RentalDto {

    private long id;
    private long exemplarId;
    private long userId;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
