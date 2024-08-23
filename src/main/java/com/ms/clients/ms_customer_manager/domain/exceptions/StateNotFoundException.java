package com.ms.clients.ms_customer_manager.domain.exceptions;

public class StateNotFoundException extends NoStackTraceException {

    public StateNotFoundException(String message) {
        super(message);
    }
    
}
