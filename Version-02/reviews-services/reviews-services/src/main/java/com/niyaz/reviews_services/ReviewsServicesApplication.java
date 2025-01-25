package com.niyaz.reviews_services;

import com.niyaz.reviews_services.dto.ReviewsContactInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ReviewsContactInfoDto.class)
public class ReviewsServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsServicesApplication.class, args);
	}

}
