package com.crud.library.exception;

public class RentalNotFoundException extends Exception {

    public RentalNotFoundException(long id) {
        super("Rental with id=" + id + " not found");
    }
}
