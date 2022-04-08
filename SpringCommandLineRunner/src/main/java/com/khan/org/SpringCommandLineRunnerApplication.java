package com.khan.org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCommandLineRunnerApplication {

	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(SpringCommandLineRunnerApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Start:::");
		SpringApplication.run(SpringCommandLineRunnerApplication.class, args);
		LOGGER.info("End:::");
	}

}
