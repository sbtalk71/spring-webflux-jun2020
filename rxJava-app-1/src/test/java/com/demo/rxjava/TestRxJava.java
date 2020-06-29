package com.demo.rxjava;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.reactivex.Observable;

public class TestRxJava {

	@Test
	public void testObservable() {

		Observable<String> greeting = Observable.just("greetings");
		
		greeting.subscribe(e->System.out.println(e));
		
	}
	@Test
	public void testFromArray() {
		Observable<String> observable=Observable.fromArray(new String[] {"Shantanu","Arun","Chandra","Preetham"});
		
		observable.count().subscribe(System.out::print);
		//observable.subscribe(name->System.out.println(name+", Welcome to Class"),Throwable::printStackTrace,()->System.out.println("Completed"));
		
	}
	
	@Test
	public void testMap() {
		Observable<String> observable=Observable.fromArray(new String[] {"Shantanu","Arun","Chandra","Preetham"});
		
		observable.map(name->name.toUpperCase()).subscribe(name->System.out.println(name+", Welcome to Class"),Throwable::printStackTrace,()->System.out.println("Completed"));
		
	}
	
	@Test
	public void testScan() {
		Observable<String> observable=Observable.fromArray(new String[] {"Shantanu","Arun","Chandra","Preetham"});
		observable.scan(new StringBuffer(), StringBuffer::append).subscribe(System.out::print);
	}
	
	//@Test
	public void testInterval() {
		Observable<Long> interval=Observable.interval(2, TimeUnit.SECONDS);
		interval.subscribe(System.out::print);
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testMerge() {
		Observable<String> observable=Observable.fromArray(new String[] {"Shantanu","Arun","Chandra","Preetham"});
		Observable<String> observable2 =Observable.fromArray(new String[]{"1","2","3","4","5","6","7","8"});
		observable2.mergeWith(observable).subscribe(System.out::println);
		
	}
}
