package com.ms.clients.ms_customer_manager.domain.usecases;

public interface UseCase<In, Out> {
    Out execute(In input);
}
