package com.ms.clients.ms_customer_manager.domain.entities;

import com.ms.clients.ms_customer_manager.domain.validations.ValidationHandler;

public interface Entity {
    public void validate(ValidationHandler handler);
}
