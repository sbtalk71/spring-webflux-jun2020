package com.demo.flow.emp.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class MainApp {

	public static void main(String[] args) throws Exception{
		
		SubmissionPublisher<Emp> publisher= new SubmissionPublisher<>();
		FreelanceSubscriber subscriber=new FreelanceSubscriber();
		MyEmpProcessor processor=new MyEmpProcessor(e-> {return new Freelancer(e.getId(), e.getId()+100, e.getName());});
		
		publisher.subscribe(processor); //service part
		
		
		processor.subscribe(subscriber); //client part
		
		List<Emp> empList=new ArrayList<>();
		
		empList.add(new Emp(1,"Shantanu"));
		empList.add(new Emp(2,"Kirthi"));
		empList.add(new Emp(3,"Mukesh"));
		empList.add(new Emp(4,"Arun"));
		empList.add(new Emp(5,"Raja"));
		
		empList.stream().forEach(e->publisher.submit(e));
		
		if(subscriber.getCounter()<empList.size()||!processor.isSubscribed(subscriber)) {
			Thread.sleep(1000);
		}
		
		publisher.close();
		System.out.println("Done processing");
	}

}
