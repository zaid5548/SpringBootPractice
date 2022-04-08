package com.khan.org;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplicationRunnerApplication implements ApplicationRunner{

	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(SpringApplicationRunnerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationRunnerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		LOGGER.info("SourceArgs::{}",Arrays.toString(args.getSourceArgs()));
	}

}
