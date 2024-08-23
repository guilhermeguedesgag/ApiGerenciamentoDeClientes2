package com.ms.clients.ms_customer_manager.domain.validations;

import java.util.List;

public interface ValidationHandler {
    
    void addError(Error error);

    List<Error> getErrors();

    boolean hasError();
}
