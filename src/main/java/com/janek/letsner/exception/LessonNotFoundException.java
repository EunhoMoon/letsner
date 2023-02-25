package com.janek.letsner.exception;

import org.springframework.http.HttpStatus;

public class LessonNotFoundException extends LetsnerException {

    private static final String MESSAGE = "해당 레슨 일정을 찾을 수 없습니다.";

    public LessonNotFoundException() {
        super(MESSAGE);
    }

    public LessonNotFoundException(Throwable cause) {
        super(MESSAGE, cause);
    }

    @Override
    public void addValidation(String fieldName, String message) {
        super.addValidation(fieldName, message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }

}
