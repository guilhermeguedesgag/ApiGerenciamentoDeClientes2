package com.ms.clients.ms_customer_manager.domain.exceptions;

public abstract class NoStackTraceException extends RuntimeException {
    public NoStackTraceException(String message) {
        super(message, null, true, false);
    }
}
