package com.ownTask.Task3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class Task3Application {
	public static void main(String[] args) {
		SpringApplication.run(Task3Application.class, args);
	}	
}

