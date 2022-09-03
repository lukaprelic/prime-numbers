package com.natwest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PrimeNumbersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeNumbersApplication.class, args);
	}

}
