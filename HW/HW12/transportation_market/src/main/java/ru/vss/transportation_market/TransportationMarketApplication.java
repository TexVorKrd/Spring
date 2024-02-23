package ru.vss.transportation_market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransportationMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportationMarketApplication.class, args);


	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("UserService",r->r.path("/userService/**")
						.uri("http://localhost:8081/"))
				.route("TransportationService",r->r.path("/transportationService/**")
						.uri("http://localhost:8082/")).build();}

}
