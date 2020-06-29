package com.demo.flow;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class FlowDemo1 {

	public static void main(String[] args) throws Exception{
		SubmissionPublisher<String> publisher=new SubmissionPublisher<>();
		
		MyNameSubscriber subscriber=new MyNameSubscriber();
		
		publisher.subscribe(subscriber);
		
		System.out.println("Going Out..");
		//
		List<String> names=Arrays.asList("Shantanu","Kiran","Thomas","John","Scott","Arun","Chandra");
		names.stream().forEach(name->publisher.submit(name));
		
		if(subscriber.getCounter()<names.size() ||!publisher.isSubscribed(subscriber)) {
			Thread.sleep(1000);
		}
		
		System.out.println("Exiting now");
		

	}

}
