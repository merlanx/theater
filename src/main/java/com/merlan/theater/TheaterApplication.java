package com.merlan.theater;

import com.merlan.theater.web.controller.application.UploadController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;

@SpringBootApplication
@ComponentScan(basePackages="com.merlan.theater")
@EnableJpaRepositories(basePackages = "com.merlan.theater.data.repository")
public class TheaterApplication {

	public static void main(String[] args) {

        SpringApplication.run(TheaterApplication.class, args);
	}
    @Bean
    CommandLineRunner init() {
        return (args) -> {
            new File(UploadController.uploadingdir).mkdirs();
        };
    }
}

