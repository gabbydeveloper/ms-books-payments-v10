package com.msbookpaymentsv10.com.co.ms_books_payments_v10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Msbookspaymentsv10Application {

	public static void main(String[] args) {
		SpringApplication.run(Msbookspaymentsv10Application.class, args);
	}

}
