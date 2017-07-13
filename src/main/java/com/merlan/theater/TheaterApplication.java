package com.merlan.theater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.merlan.theater")
@EnableJpaRepositories(basePackages = "com.merlan.theater.data.repository")
public class TheaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheaterApplication.class, args);
	}
}
