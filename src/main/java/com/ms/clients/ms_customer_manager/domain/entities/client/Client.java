package com.ms.clients.ms_customer_manager.domain.entities.client;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ms.clients.ms_customer_manager.domain.entities.Entity;
import com.ms.clients.ms_customer_manager.domain.validations.ValidationHandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client implements Entity {
    
    private String id;

    private String name;

    private String phone;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String representativeId;

    private String stateId;
    
    public static Client with(String name, String phone, String email, String representativeId, String stateId) {
        return Client.builder()
            .id(UUID.randomUUID().toString())
            .name(name)
            .phone(phone)
            .email(email)
            .createdAt(LocalDateTime.now())
            .representativeId(representativeId)
            .stateId(stateId)
            .build();
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new ClientValidator(this, handler).validate();
    }


}
