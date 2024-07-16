package com.example.micro.disc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryHotelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryHotelServiceApplication.class, args);
	}

}
