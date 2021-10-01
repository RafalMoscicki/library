package com.crud.library.exception;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(long id) {
        super("Book with id=" + id + " not found");
    }
}
