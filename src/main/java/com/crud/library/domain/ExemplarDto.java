package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExemplarDto {

    private long id;
    private ExemplarStatus status;
    private long bookId;
}
