package com.crud.library.exception;

public class ExemplarNotAvailableException extends Exception {

    public ExemplarNotAvailableException(long id) {
        super("Exemplar with id=" + id + " is not available to rent");
    }
}
