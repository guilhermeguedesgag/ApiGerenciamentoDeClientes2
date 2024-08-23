package com.ms.clients.ms_customer_manager.application.usecases;

import java.util.List;

import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientByStateUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientWithoutRepresentativeOutput;
import com.ms.clients.ms_customer_manager.application.out.ClientServicePort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetClientByStateUseCase implements GetClientByStateUseCasePort {

    private final ClientServicePort clientServicePort;

    @Override
    public List<GetClientWithoutRepresentativeOutput> execute(String stateId) {
        return clientServicePort.findByState(stateId)
            .stream()
            .map(GetClientWithoutRepresentativeOutput::from)
            .toList();
    }
    
}
