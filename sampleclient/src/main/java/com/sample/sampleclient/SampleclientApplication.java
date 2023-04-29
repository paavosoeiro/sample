package com.sample.sampleclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SampleclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleclientApplication.class, args);
	}

}
