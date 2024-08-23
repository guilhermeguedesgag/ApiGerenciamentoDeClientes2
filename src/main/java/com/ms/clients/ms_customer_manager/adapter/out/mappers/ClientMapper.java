package com.ms.clients.ms_customer_manager.adapter.out.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.ms.clients.ms_customer_manager.adapter.out.persistence.entities.ClientJpaEntity;
import com.ms.clients.ms_customer_manager.adapter.out.persistence.entities.RepresentativeJpaEntity;
import com.ms.clients.ms_customer_manager.adapter.out.persistence.entities.StateJpaEntity;
import com.ms.clients.ms_customer_manager.domain.entities.client.Client;

@Component
public class ClientMapper {
    
    public ClientJpaEntity toJpaEntity(Client client) {
        return ClientJpaEntity.builder()
            .id(UUID.fromString(client.getId()))
            .name(client.getEmail())
            .createdAt(client.getCreatedAt())
            .email(client.getEmail())
            .phone(client.getPhone())
            .representative(RepresentativeJpaEntity.builder()
                .id(UUID.fromString(client.getRepresentativeId())).build())
            .state(StateJpaEntity.builder().abbreviation(client.getStateId()).build())
            .build();
    }

    public Client toDomain(ClientJpaEntity clientJpaEntity) {
        return Client.builder()
            .id(clientJpaEntity.getId().toString())
            .name(clientJpaEntity.getName())
            .email(clientJpaEntity.getEmail())
            .phone(clientJpaEntity.getPhone())
            .representativeId(clientJpaEntity.getRepresentative().getId().toString())
            .stateId(clientJpaEntity.getState().getAbbreviation())
            .createdAt(clientJpaEntity.getCreatedAt())
            .updatedAt(clientJpaEntity.getUpdatedAt())
            .build();
    }
}
