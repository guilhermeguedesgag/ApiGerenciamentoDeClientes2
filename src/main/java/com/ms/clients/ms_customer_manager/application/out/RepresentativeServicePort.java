package com.ms.clients.ms_customer_manager.application.out;

import com.ms.clients.ms_customer_manager.application.in.dtos.RepresentativeDTO;

public interface RepresentativeServicePort {
    RepresentativeDTO findById(String id);
}
