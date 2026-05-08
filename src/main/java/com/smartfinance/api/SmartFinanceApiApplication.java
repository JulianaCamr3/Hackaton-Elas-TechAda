package com.smartfinance.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = "com.smartfinance.api")
public class SmartFinanceApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(SmartFinanceApiApplication.class, args);
	}

}
