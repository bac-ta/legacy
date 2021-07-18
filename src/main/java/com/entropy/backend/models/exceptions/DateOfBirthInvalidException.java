package com.entropy.backend.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DateOfBirthInvalidException extends ValidationException {
    public DateOfBirthInvalidException(String message) {
        super(message);
    }
}
