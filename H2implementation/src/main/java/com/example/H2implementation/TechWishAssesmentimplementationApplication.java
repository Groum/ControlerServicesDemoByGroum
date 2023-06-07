package com.example.H2implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.example.H2implementation"})
public class TechWishAssesmentimplementationApplication {
	private static final Logger logger = LogManager.getLogger(TechWishAssesmentimplementationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TechWishAssesmentimplementationApplication.class, args);
		logger.info("Application Started");
	}

}
