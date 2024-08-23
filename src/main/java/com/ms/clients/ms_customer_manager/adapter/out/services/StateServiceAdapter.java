package com.ms.clients.ms_customer_manager.adapter.out.services;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.ms.clients.ms_customer_manager.adapter.out.persistence.repository.StateRepository;
import com.ms.clients.ms_customer_manager.application.in.dtos.StateDTO;
import com.ms.clients.ms_customer_manager.application.out.StateServicePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StateServiceAdapter implements StateServicePort {

    private final StateRepository stateRepository;
     
    @Override
    public StateDTO findById(String id) {
        if (Objects.isNull(id)) return null;
       return stateRepository.findById(id)
       .map(obj -> {
            return new StateDTO(obj.getAbbreviation(), obj.getName());
       }).orElse(null);
    }
    
}
