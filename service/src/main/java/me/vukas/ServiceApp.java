package me.vukas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class ServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(ServiceApp.class, args);
	}
}
