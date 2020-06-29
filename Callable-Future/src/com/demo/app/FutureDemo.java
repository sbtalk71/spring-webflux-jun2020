package com.demo.app;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Future<Long> response = executorService.submit(new Worker());
		System.out.println("Async call made...");

		//if (response.isDone()) {
			System.out.println(response.get());
		//}

		System.out.println("I exit...");
		executorService.shutdown();
	}

}

class Worker implements Callable<Long> {

	@Override
	public Long call() throws Exception {
		Thread.sleep(5000);
		return 1L;
	}

}
