package com.it.example.domain.contract.exception;

import java.io.Serial;
import java.util.NoSuchElementException;

public class ExampleNotFoundException extends NoSuchElementException {

    @Serial
    private static final long serialVersionUID = -273202086193579845L;
    public static final String MESSAGE = "Example not found with id: %s";

    public ExampleNotFoundException(String id) {
        super(MESSAGE.formatted(id));
    }
}
