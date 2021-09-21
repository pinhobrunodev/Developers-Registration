package com.pinhobrunodev.devregistration.resources.exceptions;

import com.pinhobrunodev.devregistration.services.exceptions.InvalidFormatZipCode;
import com.pinhobrunodev.devregistration.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> notFound(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
    }

    @ExceptionHandler(InvalidFormatZipCode.class)
    public ResponseEntity<?> invalidFormat(InvalidFormatZipCode e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
