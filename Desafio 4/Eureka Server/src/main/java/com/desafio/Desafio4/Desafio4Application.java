package com.desafio.Desafio4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Desafio4Application {

	public static void main(String[] args) {
		SpringApplication.run(Desafio4Application.class, args);
	}

}
