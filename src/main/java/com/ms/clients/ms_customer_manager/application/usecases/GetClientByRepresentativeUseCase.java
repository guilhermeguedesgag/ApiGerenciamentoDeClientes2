package com.ms.clients.ms_customer_manager.application.usecases;

import java.util.List;

import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientByRepresentativeUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientWithoutRepresentativeOutput;
import com.ms.clients.ms_customer_manager.application.out.ClientServicePort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetClientByRepresentativeUseCase implements GetClientByRepresentativeUseCasePort {

    private final ClientServicePort clientServicePort;

    @Override
    public List<GetClientWithoutRepresentativeOutput> execute(String representativeId) {
        return clientServicePort.findByRepresentative(representativeId)
            .stream()
            .map(GetClientWithoutRepresentativeOutput::from)
            .toList();
    }
    
}
