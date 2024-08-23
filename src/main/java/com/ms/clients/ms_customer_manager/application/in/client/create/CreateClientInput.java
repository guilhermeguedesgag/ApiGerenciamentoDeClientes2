package com.ms.clients.ms_customer_manager.application.in.client.create;

public record CreateClientInput(
    String name,
    String email,
    String phone,
    String representativeId,
    String stateId
) {
    
}
