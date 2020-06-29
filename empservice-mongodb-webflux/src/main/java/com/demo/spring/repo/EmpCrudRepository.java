package com.demo.spring.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.demo.spring.entity.Emp;

public interface EmpCrudRepository extends ReactiveMongoRepository<Emp, Integer> {

	
}
