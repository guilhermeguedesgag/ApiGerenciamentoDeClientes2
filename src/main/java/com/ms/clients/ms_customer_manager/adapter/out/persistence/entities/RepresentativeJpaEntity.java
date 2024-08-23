package com.ms.clients.ms_customer_manager.adapter.out.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tb_representatives")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class RepresentativeJpaEntity extends BaseJpaEntity {

    private String name;

    private String phone;

    private String email;
}
