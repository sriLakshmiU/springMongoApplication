package com.spring.mongodb.demo.service;

import java.math.BigInteger;
import java.util.List;

import com.spring.mongodb.demo.collection.Customer;

import org.springframework.stereotype.Service;


public interface CustomerService {
	public BigInteger saveCustomer(Customer customer);
	public List<Customer> getCustomers();
	public Customer getCustomerById(BigInteger id);
	public List<Customer> getCustomerByName(String name);
	public void deleteCustomerById(BigInteger id);
	public Customer updateCustomerById(BigInteger id, Customer customer);
}
