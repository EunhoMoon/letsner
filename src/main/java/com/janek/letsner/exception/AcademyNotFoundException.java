package com.janek.letsner.exception;

import org.springframework.http.HttpStatus;

public class AcademyNotFoundException extends LetsnerException {

    private static final String MESSAGE = "해당하는 학원 정보를 찾을 수 없습니다.";

    public AcademyNotFoundException() {
        super(MESSAGE);
    }

    public AcademyNotFoundException(Throwable cause) {
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
