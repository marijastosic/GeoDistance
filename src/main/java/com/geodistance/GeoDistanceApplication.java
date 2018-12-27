package com.geodistance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.geodistance.entities"})
public class GeoDistanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoDistanceApplication.class, args);
	}

}

