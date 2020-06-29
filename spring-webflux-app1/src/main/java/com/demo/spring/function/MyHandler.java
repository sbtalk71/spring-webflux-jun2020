package com.demo.spring.function;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.spring.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

@Component
public class MyHandler {

	
		public Mono<ServerResponse> handleGreet(ServerRequest request){
			String name=request.pathVariable("name");
			Hooks.onOperatorDebug();
			Mono<String> reply=Mono.just(name+", Welcome to Reactive App");
			return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(reply,String.class);
		}
		
		
		
		public Mono<ServerResponse> handleAll(ServerRequest request){
			
			Flux<Person> personsFlux=Flux.just(new Person("Shantanu"),new Person("Veera"),new Person("Arun"),
					new Person("Joshua"),new Person("John"));
			return ServerResponse.ok().body(personsFlux,Person.class);
		}
}
