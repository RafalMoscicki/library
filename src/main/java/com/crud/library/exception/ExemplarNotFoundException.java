package com.crud.library.exception;

public class ExemplarNotFoundException extends Exception {

    public ExemplarNotFoundException(long id) {
        super("Exemplar with id=" + id + " not found");
    }
}
