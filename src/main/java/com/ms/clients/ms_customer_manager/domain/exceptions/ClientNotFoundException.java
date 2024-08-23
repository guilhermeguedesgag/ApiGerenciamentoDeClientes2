package com.ms.clients.ms_customer_manager.domain.exceptions;

public class ClientNotFoundException extends NoStackTraceException {

    public ClientNotFoundException(String message) {
        super(message);
    }
    
}
