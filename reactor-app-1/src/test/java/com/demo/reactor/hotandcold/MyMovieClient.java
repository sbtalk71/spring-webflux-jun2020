package com.demo.reactor.hotandcold;

import reactor.core.publisher.Flux;

public class MyMovieClient {

	public static void main(String[] args) throws Exception{
		MyMovieService ms=new MyMovieService();
		
		Flux<String> dataFlux=ms.getDataPackets();
		dataFlux.subscribe(p->System.out.println("Subscriber1 : "+p));

		Thread.sleep(5000);
		
		dataFlux.subscribe(p->System.out.println("Subscriber2 : "+p));
		
		Thread.sleep(30000);
	}

}
