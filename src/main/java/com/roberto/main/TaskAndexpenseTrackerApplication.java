package com.roberto.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.roberto.main")
public class TaskAndexpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskAndexpenseTrackerApplication.class, args);
	}

}
