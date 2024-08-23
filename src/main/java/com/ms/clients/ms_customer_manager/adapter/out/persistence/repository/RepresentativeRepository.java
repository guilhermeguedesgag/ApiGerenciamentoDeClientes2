package com.ms.clients.ms_customer_manager.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.clients.ms_customer_manager.adapter.out.persistence.entities.RepresentativeJpaEntity;

@Repository
public interface RepresentativeRepository extends JpaRepository<RepresentativeJpaEntity, UUID> {
    
}
