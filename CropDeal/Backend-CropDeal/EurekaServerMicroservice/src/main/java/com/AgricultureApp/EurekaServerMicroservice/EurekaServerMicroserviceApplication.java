package com.AgricultureApp.EurekaServerMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerMicroserviceApplication.class, args);
	}

}
