package io.javabrains.ratingscatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient 
public class RatingsCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingsCatalogServiceApplication.class, args);
	}

}
