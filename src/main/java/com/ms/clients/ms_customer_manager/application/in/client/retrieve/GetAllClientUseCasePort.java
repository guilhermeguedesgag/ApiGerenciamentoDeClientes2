package com.ms.clients.ms_customer_manager.application.in.client.retrieve;

import java.util.List;

import com.ms.clients.ms_customer_manager.domain.pagination.Pagination;
import com.ms.clients.ms_customer_manager.domain.usecases.UseCase;

public interface GetAllClientUseCasePort extends UseCase<Pagination, List<GetClientWithoutRepresentativeOutput>> {}
