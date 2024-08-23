package com.ms.clients.ms_customer_manager.adapter.out.services;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.clients.ms_customer_manager.adapter.out.mappers.ClientMapper;
import com.ms.clients.ms_customer_manager.adapter.out.persistence.repository.ClientRepository;
import com.ms.clients.ms_customer_manager.application.out.ClientServicePort;
import com.ms.clients.ms_customer_manager.domain.entities.client.Client;
import com.ms.clients.ms_customer_manager.domain.pagination.Pagination;
import com.ms.clients.ms_customer_manager.domain.pagination.Pagination.OrderType;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ClientServiceAdapter implements ClientServicePort {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    @Transactional
    @Override
    public Client save(Client client) {
        final var clientJpaEntity = clientRepository.save(clientMapper.toJpaEntity(client));
        return clientMapper.toDomain(clientJpaEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public Client findById(String id) {
        return clientRepository.findById(UUID.fromString(id))
            .map(clientMapper::toDomain).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsByEmail(String email) {
       return clientRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> list(Pagination pagination) {
        final var sortDirection = pagination.getOrder().equals(OrderType.ASC.getValue()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        final var pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize(), Sort.by(sortDirection, "id"));
        final var clientJpaEntities = clientRepository.findAll(pageRequest);
        return clientJpaEntities.getContent()
            .stream()
            .map(clientMapper::toDomain)
            .toList();
    }

    @Transactional
    @Override
    public boolean delete(String id) {
        final var client = findById(id);
        if (Objects.isNull(client)) {
            return false;
        }
        clientRepository.deleteById(UUID.fromString(client.getId()));
        return true;
    }

    @Transactional
    @Override
    public List<Client> searchByName(String name) {
        return clientRepository.findByNameContainingIgnoreCase(name)
            .stream()
            .map(clientMapper::toDomain)
            .toList();
    }

    @Override
    public List<Client> findByState(String stateId) {
        return clientRepository.findByStateAbbreviation(stateId)
            .stream()
            .map(clientMapper::toDomain)
            .toList();
    }

    @Override
    public List<Client> findByRepresentative(String representativeId) {
        return clientRepository.findByRepresentativeId(UUID.fromString(representativeId))
            .stream()
            .map(clientMapper::toDomain)
            .toList();
    }
    
}
