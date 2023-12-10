package com.janek.letsner.common.exceptions;

import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends LetsnerException {

    public ItemNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return null;
    }

}
