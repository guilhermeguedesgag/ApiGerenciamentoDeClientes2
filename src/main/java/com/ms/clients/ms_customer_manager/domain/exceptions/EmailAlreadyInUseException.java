package com.ms.clients.ms_customer_manager.domain.exceptions;

public class EmailAlreadyInUseException extends NoStackTraceException {

    public EmailAlreadyInUseException(String email) {
        super("The email address '" + email + "' is already registered.");
    }
    
}
