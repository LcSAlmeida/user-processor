package com.lccode.user_processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class UserProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProcessorApplication.class, args);
	}

}
