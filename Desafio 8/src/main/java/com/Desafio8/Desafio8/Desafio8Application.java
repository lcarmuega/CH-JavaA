package com.Desafio8.Desafio8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class Desafio8Application {

	public static void main(String[] args) {
		SpringApplication.run(Desafio8Application.class, args);
	}

}
