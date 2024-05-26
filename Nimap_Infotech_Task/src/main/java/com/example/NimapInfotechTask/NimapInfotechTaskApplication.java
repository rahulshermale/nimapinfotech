package com.example.NimapInfotechTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
@EntityScan(basePackages = "com.example.*")
@EnableJpaRepositories(basePackages = "com.example.*")
@Configuration
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class NimapInfotechTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimapInfotechTaskApplication.class, args);
	}

}
