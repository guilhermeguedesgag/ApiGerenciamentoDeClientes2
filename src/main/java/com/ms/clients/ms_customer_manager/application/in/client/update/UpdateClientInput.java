package com.ms.clients.ms_customer_manager.application.in.client.update;

public record UpdateClientInput(
    String id,
    String name,
    String phone,
    String email,
    String representativeId,
    String stateId
) {
    
    public static UpdateClientInput with(String id, String name, String phone, String email, String representativeId, String stateId) {
        return new UpdateClientInput(id, name, phone, email, representativeId, stateId);
    }
}
