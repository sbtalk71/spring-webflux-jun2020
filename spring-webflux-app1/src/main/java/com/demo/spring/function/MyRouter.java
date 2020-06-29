package com.demo.spring.function;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Component
public class MyRouter {

	
	@Bean
	public RouterFunction routes(MyHandler handler) {
		
		return RouterFunctions
				.route(
						RequestPredicates
						.GET("/demo/test/{name}"), handler::handleGreet);
	}
}
