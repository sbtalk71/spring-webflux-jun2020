package com.demo.reactor;

import org.junit.Test;

import reactor.core.publisher.Flux;

public class TestFlatMap {

	@Test
	public void testFlatMap() throws Exception{

		Flux<Flux<Integer>> flux1=Flux.just(Flux.just(1,2),Flux.just(3,4),Flux.just(5,6),Flux.just(7,8));
		
		flux1.flatMap(flux->flux.collectList()).doOnNext(y->y.forEach(System.out::println)).log().subscribe();
		
		
		//flux1.flatMap(flux->flux.collectList()).log().subscribe(System.out::println);
		Thread.sleep(10000);
	}
}
