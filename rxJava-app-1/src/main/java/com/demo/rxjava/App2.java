package com.demo.rxjava;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class App2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		List<Integer> nums=Arrays.asList(1,2,3,4,5,6,7,8,9,12);
		Observable<Integer> takeData=Observable.fromIterable(nums);
		takeData.takeUntil(n->n<4).subscribe(System.out::println);
		takeData.takeWhile(n->n<8).subscribe(System.out::println);
		
		
		Observable<String> observable=Observable.fromArray(new String[] {"Shantanu","Arun","Chandra","Preetham"});
		observable.filter(s->s.contains("ha")).subscribe(System.out::println);
		
		
		takeData.reduce((x,y)->x+y).subscribe(System.out::println);
		
		observable.map(s->s.length()).subscribe(System.out::println);
		
		Thread.sleep(Long.MAX_VALUE);
	}

}
