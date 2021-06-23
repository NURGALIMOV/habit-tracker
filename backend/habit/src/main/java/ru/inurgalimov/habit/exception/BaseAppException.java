package ru.inurgalimov.habit.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class BaseAppException extends RuntimeException {

    @Getter
    private HttpStatus status;

    public BaseAppException() {
        super();
    }

    public BaseAppException(String message) {
        super(message);
    }

    public BaseAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseAppException(Throwable cause) {
        super(cause);
    }

    protected BaseAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
