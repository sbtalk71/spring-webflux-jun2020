package com.demo.reactor.hotandcold;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class MyMovieService {

	public Flux<String> getDataPackets(){
		return Flux.interval(Duration.ofSeconds(1)).map(p->"Data Packet "+p);
	}
}
