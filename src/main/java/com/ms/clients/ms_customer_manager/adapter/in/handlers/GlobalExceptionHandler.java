package com.ms.clients.ms_customer_manager.adapter.in.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ms.clients.ms_customer_manager.application.in.models.ResponseError;
import com.ms.clients.ms_customer_manager.domain.exceptions.DomainInvalidException;
import com.ms.clients.ms_customer_manager.domain.exceptions.EmailAlreadyInUseException;
import com.ms.clients.ms_customer_manager.domain.exceptions.RepresentativeNotFoundException;
import com.ms.clients.ms_customer_manager.domain.exceptions.StateNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(DomainInvalidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseError handleDomainInvalidException(final DomainInvalidException exception) {
        final var responseError = new ResponseError("Domain Invalid", HttpStatus.BAD_REQUEST.value());
        exception.getErrors().forEach(error -> responseError.addError(error.message()));
        return responseError;
    }

    @ExceptionHandler(EmailAlreadyInUseException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseError handleEmailAlreadyInUseException(final EmailAlreadyInUseException exception) {
        final var responseError = new ResponseError("Conflict", HttpStatus.CONFLICT.value());
        responseError.addError(exception.getMessage());
        return responseError;
    }

    @ExceptionHandler(StateNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseError handleStateNotFoundException(final StateNotFoundException exception) {
        final var responseError = new ResponseError("Not found", HttpStatus.NOT_FOUND.value());
        responseError.addError(exception.getMessage());
        return responseError;
    }

    @ExceptionHandler(RepresentativeNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseError handleRepresentativeNotFoundException(final RepresentativeNotFoundException exception) {
        final var responseError = new ResponseError("Not found", HttpStatus.NOT_FOUND.value());
        responseError.addError(exception.getMessage());
        return responseError;
    }
}
