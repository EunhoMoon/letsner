package com.janek.letsner.common.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends LetsnerException {

    private static final String MESSAGE = "해당하는 회원 정보를 찾을 수 없습니다.";

    public UserNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public HttpStatus getStatusCode() {
        return null;
    }

}
