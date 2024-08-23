package com.ms.clients.ms_customer_manager.adapter.in.web.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.clients.ms_customer_manager.application.in.client.create.CreateClientInput;
import com.ms.clients.ms_customer_manager.application.in.client.create.CreateClientOutput;
import com.ms.clients.ms_customer_manager.application.in.client.create.CreateClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.delete.DeleteClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetAllClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientByRepresentativeUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientByStateUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientOutput;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.GetClientWithoutRepresentativeOutput;
import com.ms.clients.ms_customer_manager.application.in.client.retrieve.SearchClientByNameUseCasePort;
import com.ms.clients.ms_customer_manager.application.in.client.update.UpdateClientInput;
import com.ms.clients.ms_customer_manager.application.in.client.update.UpdateClientOutput;
import com.ms.clients.ms_customer_manager.application.in.client.update.UpdateClientUseCasePort;
import com.ms.clients.ms_customer_manager.domain.pagination.Pagination;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientControllerAdapter {

    private final GetAllClientUseCasePort getAllClientUseCasePort;

    private final GetClientUseCasePort getClientUseCasePort;

    private final SearchClientByNameUseCasePort searchClientByNameUseCasePort;
    
    private final DeleteClientUseCasePort deleteClientUseCasePort;

    private final CreateClientUseCasePort createClientUseCasePort;

    private final UpdateClientUseCasePort updateClientUseCasePort;

    private final GetClientByStateUseCasePort getClientByStateUseCasePort;

    private final GetClientByRepresentativeUseCasePort getClientByRepresentativeUseCasePort;
    
    @GetMapping
    public List<GetClientWithoutRepresentativeOutput> get(@RequestParam Map<String, String> params) {
        return getAllClientUseCasePort.execute(new Pagination(params));
    }

    @GetMapping(params = "name")
    public List<GetClientWithoutRepresentativeOutput> get(@RequestParam String name) {
        return searchClientByNameUseCasePort.execute(name);
    }

    @PostMapping
    public CreateClientOutput create(@RequestBody CreateClientInput createClientInput) {
        return createClientUseCasePort.execute(createClientInput);
    }
    
    @PutMapping("/{id}")
    public UpdateClientOutput update(@PathVariable UUID id, @RequestBody UpdateClientInput updateClientInput) {
        return updateClientUseCasePort.execute(UpdateClientInput.with(
            id.toString(),
            updateClientInput.name(), 
            updateClientInput.phone(), 
            updateClientInput.email(), 
            updateClientInput.representativeId(), 
            updateClientInput.stateId() 
        ));
    }

    
    @GetMapping("/{id}") 
    public GetClientOutput getById(@PathVariable UUID id) {
        return getClientUseCasePort.execute(id.toString());
    }

    @GetMapping("/by-state/{id}")
    public List<GetClientWithoutRepresentativeOutput> getByStateId(@PathVariable String id) {
        return getClientByStateUseCasePort.execute(id);
    }

    @GetMapping("/by-representative/{id}")
    public List<GetClientWithoutRepresentativeOutput> getByRepresentativeId(@PathVariable String id) {
        return getClientByRepresentativeUseCasePort.execute(id);
    }
    
    @DeleteMapping("/{id}")
    public Boolean deleteById(@PathVariable UUID id) {
        return deleteClientUseCasePort.execute(id.toString());
    }


}
