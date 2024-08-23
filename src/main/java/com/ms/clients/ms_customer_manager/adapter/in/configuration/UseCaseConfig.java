package com.ms.clients.ms_customer_manager.adapter.in.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ms.clients.ms_customer_manager.application.in.client.create.CreateClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.delete.DeleteClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetAllClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientByRepresentativeUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientByStateUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.SearchClientByNameUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.update.UpdateClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.out.ClientServicePort;
import com.ms.clients.ms_customer_manager.application.out.RepresentativeServicePort;
import com.ms.clients.ms_customer_manager.application.out.StateServicePort;
import com.ms.clients.ms_customer_manager.application.usecases.CreateClientUseCase;
import com.ms.clients.ms_customer_manager.application.usecases.DeleteClientUseCase;
import com.ms.clients.ms_customer_manager.application.usecases.GetAllClientUseCase;
import com.ms.clients.ms_customer_manager.application.usecases.GetClientByRepresentativeUseCase;
import com.ms.clients.ms_customer_manager.application.usecases.GetClientByStateUseCase;
import com.ms.clients.ms_customer_manager.application.usecases.GetClientUseCase;
import com.ms.clients.ms_customer_manager.application.usecases.SearchClientByNameUseCase;
import com.ms.clients.ms_customer_manager.application.usecases.UpdateClientUseCase;

@Configuration
public class UseCaseConfig {

    @Bean
    CreateClientUseCasePort createClientUseCasePort(
        ClientServicePort clientServicePort, 
        RepresentativeServicePort representativeServicePort,
        StateServicePort stateServicePort
    ) {
        return new CreateClientUseCase(clientServicePort, representativeServicePort, stateServicePort);
    }

    @Bean
    UpdateClientUseCasePort updateClientUseCasePort(ClientServicePort clientServicePort, RepresentativeServicePort representativeServicePort, StateServicePort stateServicePort) {
        return new UpdateClientUseCase(clientServicePort, stateServicePort, representativeServicePort);
    }

    @Bean
    GetAllClientUseCasePort getAllClientUseCasePort(ClientServicePort clientServicePort) {
        return new GetAllClientUseCase(clientServicePort);
    }

    @Bean
    GetClientUseCasePort getClientUseCasePort(
        ClientServicePort clientServicePort, 
        RepresentativeServicePort representativeServicePort,
        StateServicePort stateServicePort
    ) {
        return new GetClientUseCase(clientServicePort, representativeServicePort, stateServicePort);
    }

    @Bean
    DeleteClientUseCasePort deleteClientUseCasePort(ClientServicePort clientServicePort) {
        return new DeleteClientUseCase(clientServicePort);
    }

    @Bean
    SearchClientByNameUseCasePort searchClientByNameUseCasePort(ClientServicePort clientServicePort) {
        return new SearchClientByNameUseCase(clientServicePort);
    }

    @Bean
    GetClientByStateUseCasePort getClientByStateUseCasePort(ClientServicePort clientServicePort) {
        return new GetClientByStateUseCase(clientServicePort);
    }

    @Bean
    GetClientByRepresentativeUseCasePort getClientByRepresentativeUseCasePort(ClientServicePort clientServicePort) {
        return new GetClientByRepresentativeUseCase(clientServicePort);
    }
}
