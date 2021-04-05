package com.lordofthepushes.exceptions;

public class UnknownIdentifierException extends IllegalArgumentException {
    public UnknownIdentifierException(String errorMessage) {
        super(errorMessage);
    }
}
