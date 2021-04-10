package com.lordofthepushes.exceptions;

import java.io.Serializable;

public class UnknownIdentifierException extends IllegalArgumentException implements Serializable {
    public UnknownIdentifierException(String errorMessage) {
        super(errorMessage);
    }
}
