package com.crud.library.controller;

public class ExemplarNotFoundException extends Exception {

    public ExemplarNotFoundException(long exemplarId) {
        super("Exemplar with id=" + exemplarId + " not found");
    }
}
