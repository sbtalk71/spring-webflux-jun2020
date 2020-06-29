package com.demo.reactor.handle;

import reactor.core.publisher.Mono;

public class MonoHandleDemo {

	public static void main(String[] args) {
		
		Mono.just(5).handle((data,sink)->sink.next(data*5)).subscribe(System.out::println);
	}

}
