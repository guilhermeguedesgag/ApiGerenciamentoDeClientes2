package com.ms.clients.ms_customer_manager.adapter.out.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tb_clients")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientJpaEntity extends BaseJpaEntity {

    private String name;

    private String phone;

    private String email;

    @ManyToOne
    private RepresentativeJpaEntity representative;

    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "abbreviation")
    private StateJpaEntity state;
}
