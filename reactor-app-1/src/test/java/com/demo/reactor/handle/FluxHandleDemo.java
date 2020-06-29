package com.demo.reactor.handle;

import reactor.core.publisher.Flux;

public class FluxHandleDemo {

	public static void main(String[] args) throws Exception{
		Flux<Integer> flux1=Flux.range(1, 20);
		SeriesHandler sHandler=new SeriesHandler();
		sHandler.handleNumSequence(flux1).subscribe(System.out::println);
		
		Thread.sleep(5000);

	}

}
class SeriesHandler{

	public Flux<Integer> handleNumSequence(Flux<Integer> seq) {
		
		return seq.handle((number,sink)->{
			if(number%2==0) {
				sink.next(number/2);
			}
		});
		
	}
	
}