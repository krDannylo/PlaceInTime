package com.dev.dj.PlaceInTime.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dev.dj.PlaceInTime.messages.ValidationMessages;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<ErrorRecordResponse> handleDataConflict(DataConflictException ex) {
        var errorRecordResponse = new ErrorRecordResponse(HttpStatus.CONFLICT.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorRecordResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorRecordResponse> handleInvalidJson(HttpMessageNotReadableException ex){
        return ResponseEntity
            .badRequest()
            .body(
                new ErrorRecordResponse(HttpStatus.BAD_REQUEST.value(),
                                            ValidationMessages.INVALID_REQUEST_BODY.getMessage(),
                                            null
            ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorRecordResponse> handleValidationErrors(MethodArgumentNotValidException ex){

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> erros.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity
            .badRequest()
            .body(new ErrorRecordResponse(HttpStatus.BAD_REQUEST.value(),
                                            ValidationMessages.VALIDATION_ERROR.getMessage(),
                                            erros
            ));
    }

}
