package com.springai.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication {

	@Autowired
	private OpenAiClient openAiClient;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			String country = "Nepal"; // Example country
			String tallMountains = openAiClient.getTallMountains(country);
			System.out.println("Tall mountains in " + country + ": " + tallMountains);
		};
	}

}
