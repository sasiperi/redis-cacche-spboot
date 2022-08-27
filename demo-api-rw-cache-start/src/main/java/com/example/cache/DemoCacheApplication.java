package com.example.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class DemoCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCacheApplication.class, args);
	}

}
