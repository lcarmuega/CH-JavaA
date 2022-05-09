package com.proyectofinal.ProyectoFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class ProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

}
