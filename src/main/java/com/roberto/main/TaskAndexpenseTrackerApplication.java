package com.roberto.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.roberto.main")
public class TaskAndexpenseTrackerApplication {

	private static final Logger log = LogManager.getLogger(TaskAndexpenseTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TaskAndexpenseTrackerApplication.class, args);
	}

}
