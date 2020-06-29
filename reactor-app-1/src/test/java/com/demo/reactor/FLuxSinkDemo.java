package com.demo.reactor;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink.OverflowStrategy;

public class FLuxSinkDemo {
	public static int counter = 0;

	public static void main(String[] args) throws Exception {

		List<String> names = Arrays.asList("Shantanu", "Arun", "Chandra", "John", "Bhim");

		Flux<Integer> flux = Flux.create(sink -> {
			System.out.println("Processing..");
			
			sink.next(names.get(getCounter()).length());

		}, OverflowStrategy.BUFFER);

		flux.log().subscribe(System.out::println);

		Thread.sleep(10000);

	}

	public  static int getCounter() {
		// TODO Auto-generated method stub
		return counter++;
	}

}
