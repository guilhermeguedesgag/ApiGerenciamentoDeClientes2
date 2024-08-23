package com.ms.clients.ms_customer_manager.application.out;

import com.ms.clients.ms_customer_manager.application.in.dtos.StateDTO;

public interface StateServicePort {
    StateDTO findById(String id);
}
