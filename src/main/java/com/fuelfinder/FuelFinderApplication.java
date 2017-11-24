package com.fuelfinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:/service.properties")
public class FuelFinderApplication {

	private static final Logger log = LoggerFactory.getLogger(FuelFinderApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(FuelFinderApplication.class, args);
		log.info("Main of FuelFinderApplication Class is executed");

	}

}
