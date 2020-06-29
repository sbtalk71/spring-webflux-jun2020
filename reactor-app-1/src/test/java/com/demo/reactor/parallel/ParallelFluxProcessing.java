package com.demo.reactor.parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ParallelFluxProcessing {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService tp=Executors.newCachedThreadPool();
		//ExecutorService tp=Executors.newFixedThreadPool(3);
		
		Flux.range(1, 20)
			.parallel(10)
			.runOn(Schedulers.elastic())
			//.runOn(Schedulers.fromExecutor(tp))
			//.publishOn(Schedulers.parallel())
			.doOnNext(i->{System.out.println(String.format("Processing %s on thread %s", i,Thread.currentThread().getName()));
			
			doSomWork();
			System.out.println(String.format("Cmpleted processing %s",i));
			
			})
			.subscribe();
		
		Thread.sleep(Long.MAX_VALUE);
	}

	private static void doSomWork() {
		try {
			Thread.sleep(5000);
			System.out.println("Did the work..");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
