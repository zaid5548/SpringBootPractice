package com.khan.org.runner;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.khan.org.SpringApplicationRunnerApplication;

@Component
@Order(1)
public class MyApplicationRunner1 implements ApplicationRunner{

	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(MyApplicationRunner1.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOGGER.info("MyApplication1 run...");
		LOGGER.info("SourceArgs::{}",Arrays.toString(args.getSourceArgs()));
	}

	
}
