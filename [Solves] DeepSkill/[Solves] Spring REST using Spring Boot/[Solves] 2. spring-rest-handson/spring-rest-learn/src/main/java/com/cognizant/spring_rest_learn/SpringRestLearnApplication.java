package com.cognizant.spring_rest_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestLearnApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringRestLearnApplication.class, args);
        LOGGER.info("SpringRestLearnApplication started successfully!");
	}

}
