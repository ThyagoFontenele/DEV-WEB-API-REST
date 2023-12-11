package com.devweb.eventoapi.model;

import org.springframework.http.HttpStatus;

public class ValidationResult {
    private String errorMessage;
    private HttpStatus statusCode = HttpStatus.OK;
    private boolean isValid;

    public ValidationResult() {
        this.isValid = true;
    }

    public ValidationResult(String errorMessage) {
        this.errorMessage = errorMessage;
        statusCode = HttpStatus.UNPROCESSABLE_ENTITY;
        this.isValid = false;
    }

    public ValidationResult(String errorMessage, HttpStatus code) {
        this.errorMessage = errorMessage;
        this.statusCode = code;
        this.isValid = false;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
