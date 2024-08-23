package com.ms.clients.ms_customer_manager.application.out;

import java.util.List;

import com.ms.clients.ms_customer_manager.domain.entities.client.Client;
import com.ms.clients.ms_customer_manager.domain.pagination.Pagination;

public interface ClientServicePort {
    
    public Client save(Client client);

    public Client findById(String id);

    public boolean existsByEmail(String email);

    public List<Client> list(Pagination pagination);

    public boolean delete(String id);

    public List<Client> searchByName(String name);

    public List<Client> findByState(String stateId);

    public List<Client> findByRepresentative(String representativeId);
}
