package com.ms.clients.ms_customer_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "com.ms.clients.ms_customer_manager.adapter.out.persistence.entities")
@EnableJpaRepositories(basePackages = "com.ms.clients.ms_customer_manager.adapter.out.persistence.repository")
public class MsCustomerManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCustomerManagerApplication.class, args);
	}

}
