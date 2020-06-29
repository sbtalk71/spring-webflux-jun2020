package com.demo.reactor;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonToMany {

	public static void main(String[] args) {
		Mono.just(Arrays.asList("one", "two", "three")).log().flatMapMany(Flux::fromIterable).subscribe(System.out::println);
        Mono.just(Arrays.asList("one", "two", "three")).log().flatMapIterable(l -> l).subscribe(System.out::println);

	}

}
