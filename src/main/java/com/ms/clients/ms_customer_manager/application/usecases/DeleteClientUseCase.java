package com.ms.clients.ms_customer_manager.application.usecases;

import com.ms.clients.ms_customer_manager.application.in.client.delete.DeleteClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.out.ClientServicePort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteClientUseCase implements DeleteClientUseCasePort {

    private final ClientServicePort clientServicePort;

    @Override
    public Boolean execute(String input) {
       return clientServicePort.delete(input);
    }

}
