package com.ms.clients.ms_customer_manager.adapter.out.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_states")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StateJpaEntity {

    @Id
    private String abbreviation;

    private String name;
}
