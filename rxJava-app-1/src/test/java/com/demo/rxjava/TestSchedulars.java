package com.demo.rxjava;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class TestSchedulars {

	public static void main(String[] args) throws Exception{
		
		Observable<String> data=Observable.just("Shantanu","Arun","Joji");
		Flowable<String> data1=Flowable.just("Shantanu","Arun","Joji");
		
		data1.map(x->getLengthWithDelay(x))
		.doOnNext(s->System.out.println("Thread Name : "+Thread.currentThread().getName()))
		.subscribeOn(Schedulers.newThread())
		.subscribe(length->System.out.println("reciever Thread is "+Thread.currentThread().getName() + " with length "+length));
		
		
		Thread.sleep(Long.MAX_VALUE);
		
	}

	private static Integer getLengthWithDelay(String x) {
		try {
			Thread.sleep(5000);
			return x.length();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
