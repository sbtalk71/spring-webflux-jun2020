package com.demo.reactor.hotandcold;

import java.time.Duration;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class TvService {

	public ConnectableFlux<String> getTransmission(){
		return Flux.interval(Duration.ofSeconds(1)).map(s->"Transmission "+s).publish();
	}
}
