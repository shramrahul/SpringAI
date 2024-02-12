package com.springai.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	private OpenAiGptClient openAiGptClient;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			String country = "Nepal"; // Example country
			Mountains tallMountains = openAiGptClient.getTallMountains(country);
			ObjectMapper objectMapper = new ObjectMapper();
			System.out.println("Tall mountains in " + country + ": " + objectMapper.writeValueAsString(tallMountains));
		};
	}
}
