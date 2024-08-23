package com.ms.clients.ms_customer_manager.domain.validations.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ms.clients.ms_customer_manager.domain.validations.Error;
import com.ms.clients.ms_customer_manager.domain.validations.ValidationHandler;

public class NotificationHandler implements ValidationHandler {

    private final List<Error> errors = new ArrayList<>();

    @Override
    public void addError(Error error) {
        this.errors.add(error);
    }

    @Override
    public List<Error> getErrors() {
        return Collections.unmodifiableList(this.errors);
    }

    @Override
    public boolean hasError() {
        return !errors.isEmpty();
    }


}
