package com.ms.clients.ms_customer_manager.application.in.client.retrieve;

import java.util.List;

import com.ms.clients.ms_customer_manager.domain.usecases.UseCase;

public interface GetClientByRepresentativeUseCasePort extends UseCase<String, List<GetClientWithoutRepresentativeOutput>> {
    
}
