package com.ms.clients.ms_customer_manager.application.usecases;

import java.util.Objects;

import com.ms.clients.ms_customer_manager.application.in.client.create.CreateClientInput;
import com.ms.clients.ms_customer_manager.application.in.client.create.CreateClientOutput;
import com.ms.clients.ms_customer_manager.application.in.client.create.CreateClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.out.ClientServicePort;
import com.ms.clients.ms_customer_manager.application.out.RepresentativeServicePort;
import com.ms.clients.ms_customer_manager.application.out.StateServicePort;
import com.ms.clients.ms_customer_manager.domain.entities.client.Client;
import com.ms.clients.ms_customer_manager.domain.exceptions.DomainInvalidException;
import com.ms.clients.ms_customer_manager.domain.exceptions.EmailAlreadyInUseException;
import com.ms.clients.ms_customer_manager.domain.exceptions.RepresentativeNotFoundException;
import com.ms.clients.ms_customer_manager.domain.exceptions.StateNotFoundException;
import com.ms.clients.ms_customer_manager.domain.validations.handler.NotificationHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateClientUseCase implements CreateClientUseCasePort {

    private final ClientServicePort clientServicePort;

    private final RepresentativeServicePort representativeServicePort;

    private final StateServicePort stateServicePort;

    @Override
    public CreateClientOutput execute(final CreateClientInput input) {

       final var representative = representativeServicePort.findById(input.representativeId());

        if (Objects.isNull(representative)) {
            throw new RepresentativeNotFoundException("Representative not found with id: " + input.representativeId());
        }

        if (clientServicePort.existsByEmail(input.email())) {
            throw new EmailAlreadyInUseException(input.email());
        }

        final var state = stateServicePort.findById(input.stateId());

        if (Objects.isNull(state)) {
            throw new StateNotFoundException("State not found with id: " + input.stateId());
        }

       final var client = Client.with(input.name(), input.phone(), input.email(), input.representativeId(), state.abbreviation());
       final var validationHandler = new NotificationHandler();

       client.validate(validationHandler);

       if (validationHandler.hasError()) {
            throw new DomainInvalidException(validationHandler.getErrors());
       }

       return new CreateClientOutput(clientServicePort.save(client).getId());
    }
    
}
