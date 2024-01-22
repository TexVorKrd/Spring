package com.example.sem3HomeTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.sem3HomeTask")
public class Sem3HomeTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sem3HomeTaskApplication.class, args);
	}

}
