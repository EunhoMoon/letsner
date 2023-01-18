package com.janek.letsner.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class LetsnerException extends RuntimeException {

    private final Map<String, String> validation = new ConcurrentHashMap<>();

    public LetsnerException(String message) {
        super(message);
    }

    public LetsnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getStatusCode();

    public void addValidation(String fieldName, String message) {
        validation.put(fieldName, message);
    }

}
