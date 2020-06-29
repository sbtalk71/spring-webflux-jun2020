package com.demo.spring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rest")
public class ReactiveTestController {
	
	@ExceptionHandler(RuntimeException.class)
	public Mono<String> handleRuntimeException(RuntimeException e){
		System.out.println("Error Handled from here..");
		return Mono.error(e);
	}

	//@RequestMapping(path="/test/{name}",method = RequestMethod.GET)
	@GetMapping("/test/{name}")
	public Mono<String> greet(@PathVariable("name") String name){
		
		Mono<String> reply=Mono.just(name+", Welcome to Reactive App");
		throw new RuntimeException("Not a Valid User");
	}
	
	@GetMapping(path="/all",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Flux<Person> getAllNames(){
		
		return Flux.just(new Person("Shantanu"),new Person("Veera"),new Person("Arun"),
				new Person("Joshua"),new Person("John"));
	}
}
