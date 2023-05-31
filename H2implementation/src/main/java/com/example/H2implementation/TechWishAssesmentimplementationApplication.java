package com.example.H2implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.H2implementation"})
public class TechWishAssesmentimplementationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechWishAssesmentimplementationApplication.class, args);
	}

}
