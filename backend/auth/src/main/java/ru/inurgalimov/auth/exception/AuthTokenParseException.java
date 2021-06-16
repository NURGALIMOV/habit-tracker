package ru.inurgalimov.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthTokenParseException extends RuntimeException {

    public AuthTokenParseException(String message) {
        super(message);
    }

    public AuthTokenParseException(String message, Throwable cause) {
        super(message, cause);
    }

}
