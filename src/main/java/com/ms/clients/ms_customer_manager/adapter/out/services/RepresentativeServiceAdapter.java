package com.ms.clients.ms_customer_manager.adapter.out.services;

import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ms.clients.ms_customer_manager.adapter.out.persistence.repository.RepresentativeRepository;
import com.ms.clients.ms_customer_manager.application.in.dtos.RepresentativeDTO;
import com.ms.clients.ms_customer_manager.application.out.RepresentativeServicePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RepresentativeServiceAdapter implements RepresentativeServicePort {

    private final RepresentativeRepository representativeRepository;

    @Override
    public RepresentativeDTO findById(String id) {
        if (Objects.isNull(id)) return null;
       return representativeRepository.findById(UUID.fromString(id))
        .map(obj -> {
            return new RepresentativeDTO(
                obj.getId().toString(),
                obj.getName(),
                obj.getEmail(),
                obj.getPhone()
            );
        }).orElse(null);
    }
    
}
