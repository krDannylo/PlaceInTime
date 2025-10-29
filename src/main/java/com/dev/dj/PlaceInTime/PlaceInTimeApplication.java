package com.dev.dj.PlaceInTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PlaceInTimeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PlaceInTimeApplication.class, args);
		String port = context.getEnvironment().getProperty("server.port");
		IO.print("Server is running on port: " + port);
	}

}
