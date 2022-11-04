package com.tein8.easybus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EasybusApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasybusApplication.class, args);
	}

}
