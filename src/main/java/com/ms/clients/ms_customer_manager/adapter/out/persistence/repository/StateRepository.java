package com.ms.clients.ms_customer_manager.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.clients.ms_customer_manager.adapter.out.persistence.entities.StateJpaEntity;

@Repository
public interface StateRepository extends JpaRepository<StateJpaEntity, String> {
    
}
