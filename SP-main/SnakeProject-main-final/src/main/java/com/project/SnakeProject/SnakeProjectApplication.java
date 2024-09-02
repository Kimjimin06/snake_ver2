package com.project.SnakeProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SnakeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnakeProjectApplication.class, args);
	}

}
