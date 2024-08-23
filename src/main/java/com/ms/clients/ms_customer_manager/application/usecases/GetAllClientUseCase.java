package com.ms.clients.ms_customer_manager.application.usecases;

import java.util.List;

import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetAllClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientWithoutRepresentativeOutput;
import com.ms.clients.ms_customer_manager.application.out.ClientServicePort;
import com.ms.clients.ms_customer_manager.domain.pagination.Pagination;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAllClientUseCase implements GetAllClientUseCasePort {

    private final ClientServicePort clientServicePort;

    @Override
    public List<GetClientWithoutRepresentativeOutput> execute(final Pagination input) {
       return clientServicePort.list(input).stream().map(GetClientWithoutRepresentativeOutput::from).toList();
    }
    
}
