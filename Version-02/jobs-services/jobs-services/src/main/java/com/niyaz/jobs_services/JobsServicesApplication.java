package com.niyaz.jobs_services;

import com.niyaz.jobs_services.dto.JobsContactInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(JobsContactInfoDto.class)
public class JobsServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobsServicesApplication.class, args);
	}

}
