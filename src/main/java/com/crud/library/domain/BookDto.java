package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookDto {

    private long id;
    private String title;
    private String author;
    private int year;
}
