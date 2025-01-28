package com.niyaz.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator jOBSAppRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/JobApp/company/**")
						.filters(f -> f
								.rewritePath("/JobApp/company/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("companyCircuitBreaker")
										.setFallbackUri("forward:/contactSupport"))
								)

						.uri("lb://Company"))
				.route(p -> p
						.path("/JobApp/jobs/**")
						.filters(f -> f
								.rewritePath("/JobApp/jobs/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("jobsCircuitBreaker")
										.setFallbackUri("forward:/contactSupport"))
								)

						.uri("lb://JOBS"))
				.route(p -> p
						.path("/JobApp/reviews/**")
						.filters(f -> f
								// Rewrite the path by extracting the part after /accounts/ and use it as the new path
								.rewritePath("/JobApp/reviews/(?<segment>.*)", "/${segment}")
								// Add a custom response header 'X-Response-Time' with the current time
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("reviewsCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://REVIEWS"))
				.build();


	}
}
