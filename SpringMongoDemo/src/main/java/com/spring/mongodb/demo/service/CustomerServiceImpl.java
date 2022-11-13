package com.spring.mongodb.demo.service;

import java.math.BigInteger;
import java.util.List;

import com.spring.mongodb.demo.Exception.CustomerNotFoundException;
import com.spring.mongodb.demo.collection.Customer;
import com.spring.mongodb.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	private CustomerRepository customerRepository;
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public BigInteger saveCustomer(Customer customer) {
		return customerRepository.save(customer).getId();
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(BigInteger id) {
		return customerRepository.findById(id).orElseThrow(() ->  new CustomerNotFoundException("Customer", "id", id));
	}

	@Override
	public List<Customer> getCustomerByName(String name) {
		return customerRepository.findByName(name);
	}

	@Override
	public void deleteCustomerById(BigInteger id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer updateCustomerById(BigInteger id, Customer customer) {
		Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer","id",id));
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setName(customer.getName());
		existingCustomer.setPhone(customer.getPhone());
		customerRepository.save(existingCustomer);
		return existingCustomer;
	}
	
	
}
