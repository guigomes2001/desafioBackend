package com.demo.desafiobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo.controller, com.demo.desafiobackend")
public class DesafiobackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiobackendApplication.class, args);
	}

}
