package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserDto {

    private long id;
    private String name;
    private String lastName;
    private LocalDate create;
}
