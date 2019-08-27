package ru.eltex.laba7.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class Exceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity handleNullExceptions() {
        return new ResponseEntity("No Order(1)", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IOException.class)
    private ResponseEntity corruptedFile() {
        return new ResponseEntity("Corrupted file(2)", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    private ResponseEntity wrongWay() {
        return new ResponseEntity("Wrong command(3)", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
