package com.ms.clients.ms_customer_manager.application.usecases;

import java.util.List;

import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientWithoutRepresentativeOutput;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.SearchClientByNameUseCasePort;
import com.ms.clients.ms_customer_manager.application.out.ClientServicePort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchClientByNameUseCase implements SearchClientByNameUseCasePort {

    private final ClientServicePort clientServicePort;

    @Override
    public List<GetClientWithoutRepresentativeOutput> execute(String input) {
        return clientServicePort.searchByName(input).stream().map(GetClientWithoutRepresentativeOutput::from).toList();
    }
    
}
