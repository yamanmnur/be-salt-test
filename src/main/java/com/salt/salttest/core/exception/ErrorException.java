package com.salt.salttest.core.exception;

import com.salt.salttest.core.error.GenericError;

public class ErrorException extends Exception {
    private final GenericError error;

    public ErrorException(GenericError error) {
        this.error = error;
    }

    public GenericError getError() {
        return this.error;
    }
}
