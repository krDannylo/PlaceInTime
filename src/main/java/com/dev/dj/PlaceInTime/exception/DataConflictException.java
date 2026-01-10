package com.dev.dj.PlaceInTime.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class DataConflictException extends RuntimeException {
    public DataConflictException(String message) {
        super(message);
    }
}