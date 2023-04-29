package com.poc.sampleservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.poc.sampleservice.entity.Sample;
import com.poc.sampleservice.model.SampleDto;
import com.poc.sampleservice.repository.SampleRepository;
import com.poc.sampleservice.service.SampleService;

@SpringBootApplication
public class SampleserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner initSamples(@Qualifier("sampleServiceImpl") SampleService service, SampleRepository repository) {
		return args -> {
			service.add(SampleDto.builder().name("Sample").build());
			// repository.insert(Sample.builder().name("Sample").build());
		};
	}

}
