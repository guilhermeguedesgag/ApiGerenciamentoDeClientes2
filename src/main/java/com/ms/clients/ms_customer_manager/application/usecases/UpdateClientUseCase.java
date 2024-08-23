package com.ms.clients.ms_customer_manager.application.usecases;

import java.util.Objects;

import com.ms.clients.ms_customer_manager.application.in.client.update.UpdateClientInput;
import com.ms.clients.ms_customer_manager.application.in.client.update.UpdateClientOutput;
import com.ms.clients.ms_customer_manager.application.in.client.update.UpdateClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.out.ClientServicePort;
import com.ms.clients.ms_customer_manager.application.out.RepresentativeServicePort;
import com.ms.clients.ms_customer_manager.application.out.StateServicePort;
import com.ms.clients.ms_customer_manager.domain.exceptions.ClientNotFoundException;
import com.ms.clients.ms_customer_manager.domain.exceptions.DomainInvalidException;
import com.ms.clients.ms_customer_manager.domain.exceptions.EmailAlreadyInUseException;
import com.ms.clients.ms_customer_manager.domain.exceptions.RepresentativeNotFoundException;
import com.ms.clients.ms_customer_manager.domain.exceptions.StateNotFoundException;
import com.ms.clients.ms_customer_manager.domain.validations.handler.NotificationHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateClientUseCase implements UpdateClientUseCasePort {

    private final ClientServicePort clientServicePort;

    private final StateServicePort stateServicePort;

    private final RepresentativeServicePort representativeServicePort;
    
    @Override
    public UpdateClientOutput execute(UpdateClientInput input) {

        final var client = clientServicePort.findById(input.id());

        if (Objects.isNull(client)) {
            throw new ClientNotFoundException("Client not found with id: " + input.id());
        }

        if (clientServicePort.existsByEmail(input.email()) && !client.getEmail().equalsIgnoreCase(input.email())) {
            throw new EmailAlreadyInUseException(input.email());
        }

        final var representative = representativeServicePort.findById(input.representativeId());

        if (Objects.isNull(representative)) {
            throw new RepresentativeNotFoundException("Representative not found with id: " + input.representativeId());
        }

        final var state = stateServicePort.findById(input.stateId());

        if (Objects.isNull(state)) {
            throw new StateNotFoundException("State not found with id: " + input.stateId());
        }

        client.setName(input.name());
        client.setPhone(input.phone());
        client.setEmail(input.email());
        client.setRepresentativeId(input.representativeId());
        client.setStateId(input.stateId());

        final var validationHandler = new NotificationHandler();

       client.validate(validationHandler);


       System.out.println(validationHandler.hasError());

       if (validationHandler.hasError()) {
            throw new DomainInvalidException(validationHandler.getErrors());
       }

        return new UpdateClientOutput(clientServicePort.save(client).getId());
    }
    
}
