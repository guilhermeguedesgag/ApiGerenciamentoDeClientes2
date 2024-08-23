package com.ms.clients.ms_customer_manager.domain.entities.client;

import java.util.Objects;

import com.ms.clients.ms_customer_manager.domain.validations.Error;
import com.ms.clients.ms_customer_manager.domain.validations.ValidationHandler;
import com.ms.clients.ms_customer_manager.domain.validations.Validator;

public class ClientValidator implements Validator {

    private final Client target;
    private final ValidationHandler handler;

    public ClientValidator(Client target, ValidationHandler handler) {
        this.target = target;
        this.handler = handler;
    }

    @Override
    public void validate() {
        if (Objects.isNull(target)) {
            handler.addError(new Error("Cliente inválido"));
            return;
        }

        // Validar nome
        if (Objects.isNull(target.getName()) || target.getName().trim().isEmpty()) {
            handler.addError(new Error("Nome do cliente é obrigatório"));
        }

        // Validar e-mail
        String email = target.getEmail();
        if (Objects.isNull(email) || email.trim().isEmpty()) {
            handler.addError(new Error("E-mail do cliente é obrigatório"));
        } else if (!isValidEmail(email)) {
            handler.addError(new Error("E-mail do cliente é inválido"));
        }

        String representativeId = target.getRepresentativeId();

        if (Objects.isNull(representativeId)) {
            handler.addError(new Error("Representante é obrigátorio"));
        }

        String stateId = target.getStateId();

        if (Objects.isNull(stateId)) {
            handler.addError(new Error("Estado é obrigátorio"));
        }

        // Validar telefone
        String phone = target.getPhone();
        if (Objects.isNull(phone) || phone.trim().isEmpty()) {
            handler.addError(new Error("Telefone do cliente é obrigatório"));
        } else if (!isValidPhone(phone)) {
            handler.addError(new Error("Telefone do cliente é inválido"));
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    private boolean isValidPhone(String phone) {
        String phoneRegex = "^\\+?[1-9]\\d{1,14}$";
        return phone.matches(phoneRegex);
    }
}
