package com.demo.reactor.errors;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;
import reactor.test.StepVerifier;

public class TestErrors {

	@Test
	public void testErroOnResume() throws InterruptedException {
		Flux<Integer> numsFlux = Flux.just(1, 2, 3, 4, 5).concatWith(Flux.error(new RuntimeException("Test not done")))
				.concatWith(Flux.just(8)).concatWith(Flux.error(new ArithmeticException("Divide by Zero")))
				.onErrorResume(e -> handleError(e));

		// numsFlux.subscribe(System.out::println);
		// Thread.sleep(10000);

		StepVerifier.create(numsFlux).expectNext(1, 2, 3, 4, 5).expectNext(2, 3).verifyComplete();

	}

	@Test
	public void testErroContinue() throws InterruptedException {
		Flux<Integer> numsFlux = Flux.just(1, 2, 3, 4, 5)
				.concatWith(Flux.error(new RuntimeException("Error Happened")))
				.concatWith(Flux.just(8))
				.onErrorContinue((e, i) -> {
					System.out.println("Error " + e.getMessage() + " While processing " + i);
				});

		numsFlux.subscribe(System.out::println);
		Thread.sleep(10000);
	}

	
	@Test
	public void testDoOnError() throws InterruptedException {
		Flux<Integer> numsFlux = Flux.just(1, 2, 3, 4, 5)
				.concatWith(Flux.error(new RuntimeException("Error Happened")))
				.concatWith(Flux.just(8))
				.doOnError(t->handleError1(t));

		numsFlux.subscribe(System.out::println);
		Thread.sleep(10000);
	}
	
	@Test
	public void testDoFinnaly() throws InterruptedException {
		Flux<Integer> numsFlux = Flux.just(1, 2, 3, 4, 5)
				.concatWith(Flux.error(new RuntimeException("Error Happened-1")))
				.concatWith(Flux.error(new RuntimeException("Error Happened-2")))
				.concatWith(Flux.just(8))
				.doFinally(i->{
					if(SignalType.ON_ERROR.equals(i)) {
						System.out.println("done with error");
					}
					if(SignalType.ON_COMPLETE.equals(i)) {
						System.out.println("done successfully");
					}
				});

		numsFlux.subscribe(System.out::println);
		Thread.sleep(10000);
	}
	
	//handlers
	public Flux<Integer> handleError(Throwable t) {
		System.out.println("Exception handled : " + t.getMessage());
		return Flux.just(2, 3);
	}
	
	public void handleError1(Throwable t) {
		System.out.println("Exception handled : " + t.getMessage());
		
	}
}
