package com.crud.library.domain;

import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String lastName;

    @Column(name = "date")
    @Unsigned
    @DateTimeFormat
    private LocalDate create;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getCreate() {
        return create;
    }
}
