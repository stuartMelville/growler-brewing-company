package com.gbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GrowlerBrewingCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrowlerBrewingCompanyApplication.class, args);
	}
}
