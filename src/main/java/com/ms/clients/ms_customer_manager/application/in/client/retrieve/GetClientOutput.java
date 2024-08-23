package com.ms.clients.ms_customer_manager.application.in.client.retrieve;

import com.ms.clients.ms_customer_manager.application.in.dtos.RepresentativeDTO;
import com.ms.clients.ms_customer_manager.application.in.dtos.StateDTO;
import com.ms.clients.ms_customer_manager.domain.entities.client.Client;

public record GetClientOutput(
    String id,
    String name,
    String email,
    String phone,
    RepresentativeDTO representative,
    StateDTO state
) {
    
    public static GetClientOutput from(final Client client, RepresentativeDTO representative, StateDTO state) {
        return new GetClientOutput(
            client.getId(),
            client.getName(),
            client.getEmail(),
            client.getPhone(),
            representative,
            state
        );
    }
}
