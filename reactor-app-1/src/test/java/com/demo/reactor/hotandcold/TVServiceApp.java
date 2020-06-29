package com.demo.reactor.hotandcold;

import reactor.core.publisher.ConnectableFlux;

public class TVServiceApp {

	public static void main(String[] args) throws InterruptedException {
		
		TvService tvService=new TvService();
		
		ConnectableFlux<String> hotFlux=tvService.getTransmission();
		
		hotFlux.subscribe(data->System.out.println("Subscriber 1 : "+data));

		hotFlux.connect();
		
		Thread.sleep(5000);
		
		hotFlux.subscribe(data->System.out.println("Subscriber 2 : "+data));
		
		Thread.sleep(30000);
	}

}
