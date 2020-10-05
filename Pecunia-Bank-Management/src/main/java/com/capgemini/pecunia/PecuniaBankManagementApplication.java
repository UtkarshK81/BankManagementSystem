package com.capgemini.pecunia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class PecuniaBankManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecuniaBankManagementApplication.class, args);
	}

}
