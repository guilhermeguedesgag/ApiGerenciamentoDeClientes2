package com.ms.clients.ms_customer_manager.domain.exceptions;

import java.util.List;

import com.ms.clients.ms_customer_manager.domain.validations.Error;

import lombok.Getter;

@Getter
public class DomainInvalidException extends NoStackTraceException {

    private List<Error> errors;

    public DomainInvalidException(final List<Error> errors) {
        super(null);
        this.errors = errors;
    }

    public DomainInvalidException(String message) {
        super(message);
    }
    
}
