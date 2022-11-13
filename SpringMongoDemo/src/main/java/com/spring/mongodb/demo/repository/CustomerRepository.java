package com.spring.mongodb.demo.repository;

import java.math.BigInteger;
import java.util.List;

import com.spring.mongodb.demo.collection.Customer;

import org.springframework.data.mongodb.core.ExecutableUpdateOperation.FindAndModifyWithOptions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, BigInteger>{

	List<Customer> findByName(String name);
	
}
