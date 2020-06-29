package com.demo.flow;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MyNameSubscriber implements Subscriber<String> {

	Subscription subscription;
	int counter=0;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription=subscription;
		subscription.request(1);

	}

	@Override
	public void onNext(String item) {
		System.out.println("Name Now is : "+item);
		counter++;
		subscription.request(1);

	}

	@Override
	public void onError(Throwable throwable) {
		throwable.printStackTrace();

	}

	@Override
	public void onComplete() {
		System.out.println("Processed data successfully...");

	}
	
	public int getCounter() {
		return this.counter;
	}

}
