package com.ms.clients.ms_customer_manager.application.in.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;


@Getter
public class ResponseError {
    private String title;
    private int statusCode;
    private final List<String> errors = new ArrayList<>();

    public ResponseError(String title, int statusCode) {
        this.title = title;
        this.statusCode = statusCode;
    }

    public void addError(String error) {
        errors.add(error);
    }
}
