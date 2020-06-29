package com.demo.flow.emp.app;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class FreelanceSubscriber implements Subscriber<Freelancer> {

	Subscription subscription;
	int counter=0;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription=subscription;
		subscription.request(1);

	}

	@Override
	public void onNext(Freelancer item) {
		System.out.println("processing : "+item);
		counter++;
		subscription.request(1);

	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("from Subscriber Error : "+throwable.getMessage());

	}

	@Override
	public void onComplete() {
		System.out.println("Processed data successfully...");

	}
	
	public int getCounter() {
		return this.counter;
	}

}
