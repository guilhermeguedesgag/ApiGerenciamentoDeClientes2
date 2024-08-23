package com.ms.clients.ms_customer_manager.application.in.dtos;

public record StateDTO(
    String abbreviation,
    String name
){

    public static StateDTO from(String id, String abbreviation, String name) {
        return new StateDTO(abbreviation, name);
    }
}
