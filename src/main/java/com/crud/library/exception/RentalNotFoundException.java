package com.crud.library.exception;

public class RentalNotFoundException extends Exception {

    public RentalNotFoundException(long id) {
        super("Rental with id=" + id + " not found");
    }

    public RentalNotFoundException(long userId, long exemplarId) {
        super("Rental for userId=" + userId + " and exemplarId=" + exemplarId + " not found");
    }
}
