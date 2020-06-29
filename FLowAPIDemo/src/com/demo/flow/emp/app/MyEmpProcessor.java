package com.demo.flow.emp.app;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class MyEmpProcessor extends SubmissionPublisher<Freelancer> implements Processor<Emp, Freelancer> {

	Subscription subscription;
	int counter=0;
	Function<Emp, Freelancer> function;
	
	
	public MyEmpProcessor(Function<Emp, Freelancer> function) {
		this.function = function;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription=subscription;
		subscription.request(1);

	}

	@Override
	public void onNext(Emp item) {
		submit((Freelancer)function.apply(item));
		subscription.request(1);

	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("Error : "+throwable.getMessage());

	}

	@Override
	public void onComplete() {
		System.out.println("Done");

	}

}
