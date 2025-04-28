package com.example.subcription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.subcription.Controller"})
public class SubcriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubcriptionApplication.class, args);
	}

}
