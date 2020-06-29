package com.demo.reactor.cache;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import reactor.core.publisher.Flux;

public class FluxCacheNoCache {

	@Test
	public void testNoCache() throws InterruptedException{
		Flux<Long> flux1=Flux.interval(Duration.ofSeconds(1)).share();
		
		flux1.subscribe(data->System.out.println("firstFlux Data : "+data));
		new CountDownLatch(1).await(5,TimeUnit.SECONDS);
		
		Flux<Long> flux2=Flux.from(flux1);
		
		flux2.subscribe(data->System.out.println("secondFlux Data : "+data));
		new CountDownLatch(1).await(5,TimeUnit.SECONDS);
		
		
		
	}
	
	@Test
	public void testCache() throws InterruptedException{
		Flux<Long> flux1=Flux.interval(Duration.ofSeconds(1)).share().cache();
		
		flux1.subscribe(data->System.out.println("firstFlux Data : "+data));
		new CountDownLatch(1).await(5,TimeUnit.SECONDS);
		
		Flux<Long> flux2=Flux.from(flux1);
		
		flux2.subscribe(data->System.out.println("secondFlux Data : "+data));
		new CountDownLatch(1).await(5,TimeUnit.SECONDS);
		
		
		
	}
}
