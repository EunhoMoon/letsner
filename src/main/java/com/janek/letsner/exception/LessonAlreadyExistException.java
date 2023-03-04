package com.janek.letsner.exception;

import org.springframework.http.HttpStatus;

public class LessonAlreadyExistException extends LetsnerException {

    private static final String MESSAGE = "해당 시간에 이미 레슨 일정이 존재합니다.";

    public LessonAlreadyExistException() {
        super(MESSAGE);
    }

    public LessonAlreadyExistException(Throwable cause) {
        super(MESSAGE, cause);
    }

    @Override
    public void addValidation(String fieldName, String message) {
        super.addValidation(fieldName, message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }

}
