package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class EmpserviceR2dbcWebfluxApplication {

	public static void main(String[] args) {
		ReactorDebugAgent.init();
		SpringApplication.run(EmpserviceR2dbcWebfluxApplication.class, args);
	}

}
