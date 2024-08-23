package com.ms.clients.ms_customer_manager.adapter.out.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.clients.ms_customer_manager.adapter.out.persistence.entities.ClientJpaEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientJpaEntity, UUID> {
    
    boolean existsByEmail(String email);

    List<ClientJpaEntity> findByNameContainingIgnoreCase(String name);

    List<ClientJpaEntity> findByStateAbbreviation(String stateId);

    List<ClientJpaEntity> findByRepresentativeId(UUID representativeId);
}
