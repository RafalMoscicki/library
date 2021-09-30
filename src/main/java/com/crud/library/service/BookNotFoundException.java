package com.crud.library.service;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(long id) {
        super("Book with id=" + id + " not found");
    }
}
