package com.ms.clients.ms_customer_manager.application.in.client.retrieve;

import com.ms.clients.ms_customer_manager.domain.entities.client.Client;

public record GetClientWithoutRepresentativeOutput(
    String id,
    String name,
    String email,
    String phone
) {
    public static GetClientWithoutRepresentativeOutput from(final Client client) {
        return new GetClientWithoutRepresentativeOutput(
            client.getId(),
            client.getName(),
            client.getEmail(),
            client.getPhone()
        );
    }
}
