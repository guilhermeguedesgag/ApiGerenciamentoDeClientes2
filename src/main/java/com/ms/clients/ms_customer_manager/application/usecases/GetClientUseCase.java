package com.ms.clients.ms_customer_manager.application.usecases;

import java.util.Objects;

import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientOutput;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.out.ClientServicePort;
import com.ms.clients.ms_customer_manager.application.out.RepresentativeServicePort;
import com.ms.clients.ms_customer_manager.application.out.StateServicePort;
import com.ms.clients.ms_customer_manager.domain.exceptions.ClientNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetClientUseCase implements GetClientUseCasePort {

    private final ClientServicePort clientServicePort;

    private final RepresentativeServicePort representativeServicePort;

    private final StateServicePort stateServicePort;

    @Override
    public GetClientOutput execute(final String id) {
        final var client = clientServicePort.findById(id);

        if (Objects.isNull(client)) {
              throw new ClientNotFoundException("Client not found with id: " + id);
        }

        final var representative = representativeServicePort.findById(client.getRepresentativeId());
        final var state = stateServicePort.findById(client.getStateId());

        return GetClientOutput.from(client, representative, state);
    }
    
}
