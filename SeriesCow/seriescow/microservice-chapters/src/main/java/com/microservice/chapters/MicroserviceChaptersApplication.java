package com.microservice.chapters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient

@SpringBootApplication
public class MicroserviceChaptersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceChaptersApplication.class, args);
	}

}
