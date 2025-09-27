package com.pathfinder.restfull.poc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex,WebRequest request) throws Exception{
        ErrorDetails details = new ErrorDetails();
        details.setErrorMessage(ex.getMessage());
        details.setErrorDetails(request.getDescription(false));
        return new ResponseEntity<Object>(details,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleInternalServerException(Exception ex,WebRequest request) throws Exception{
        ErrorDetails details = new ErrorDetails();
        details.setErrorMessage(ex.getMessage());
        details.setErrorDetails(request.getDescription(false));
        return new ResponseEntity<Object>(details,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
