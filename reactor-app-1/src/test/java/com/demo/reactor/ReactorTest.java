package com.demo.reactor;

import java.time.Duration;
import java.util.List;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuples;

public class ReactorTest {

	Flux<Integer> evenNumbers = Flux.fromArray(new Integer[] { 2, 4, 6, 8, 10, 12, 14, 16 });
	Flux<Integer> oddNumbers = Flux.fromArray(new Integer[] { 1, 3, 5, 7, 9, 11, 15, 17, 19 });

	@Test
	public void testMap() {

		evenNumbers.map(x -> x * x).filter(x -> (x > 100)).subscribe(System.out::println);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void testConcat() {
		Flux<Integer> data = Flux.concat(oddNumbers, evenNumbers);
		data.subscribe(System.out::println);
	}

	@Test
	public void testMerge() {
		Flux<Integer> data = Flux.merge(oddNumbers, evenNumbers);
		data.subscribe(System.out::println);
	}

	@Test
	public void testMergeWIth() {
		Flux<Integer> data = evenNumbers.mergeWith(oddNumbers);
		data.subscribe(System.out::println);
	}

	@Test
	public void testZip() {
		Flux<Integer> data = Flux.zip(oddNumbers, evenNumbers, (a, b) -> (a + b));
		data.subscribe(System.out::println);
	}

	@Test
	public void testInterval() {

		Flux<Long> pulseData = Flux.interval(Duration.ofSeconds(2));
		pulseData.subscribe(System.out::println);

		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGenerate() {
		Flux<Long> data = Flux.generate(() -> 1, (state, sink) -> {
			sink.next(state + 10L);
			return state;
		});

		data.take(10).subscribe(System.out::println);

		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testData() {
		Flux<Integer> nums = Flux.fromArray(new Integer[] { 2, 4, 6, 8 });
		long count = nums.count().block();

		StepVerifier.create(nums).expectNext(2).expectNext(4).expectNext(6).expectNext(8).verifyComplete();

	}

	@Test
	public void testFibbo() {
		getFibonacci().take(20).subscribe(System.out::println);
	}

	public Flux<Long> getFibonacci() {
		Flux<Long> series = Flux.generate(() -> Tuples.<Long, Long>of(0L, 1L), (state, sink) -> {
			sink.next(state.getT1());
			System.out.println("generated value : " + state.getT1());
			return Tuples.of(state.getT2(), state.getT1() + state.getT2());
		});
		return series;
	}

	@Test
	public void testCombineLatest() {
			Flux.combineLatest(evenNumbers, oddNumbers, (x,y)->(x+y))
			.subscribe(System.out::println);
			
	}

	@Test
	public void testCollect() {
		Flux<Integer> numFlux=Flux.just(1,2,3,4,5,6,7,8);
		
		Mono<List<Integer>> monoList=numFlux.collectList();
		monoList.subscribe(list->list.forEach(System.out::println));
		
		numFlux.collectSortedList((a,b)->b.compareTo(a)).subscribe(list->list.forEach(System.out::println));
		
		//numFlux.collectMap(x->{});
	}
}
