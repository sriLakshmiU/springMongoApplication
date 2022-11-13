package com.spring.mongodb.demo.controller;

import java.math.BigInteger;
import java.util.List;

import com.spring.mongodb.demo.collection.Customer;
import com.spring.mongodb.demo.service.CustomerService;
import com.spring.mongodb.demo.service.SequenceGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class CustomerController {
	
	
	private CustomerService customerService;
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	public CustomerController(CustomerService customerService, SequenceGeneratorService sequenceGeneratorService) {
		super();
		this.customerService = customerService;
		this.sequenceGeneratorService = sequenceGeneratorService;
	}
	@PostMapping
	public ResponseEntity<BigInteger> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<BigInteger>(customerService.saveCustomer(customer),HttpStatus.CREATED);
	}
	@GetMapping
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable ("id") BigInteger id){
		return new ResponseEntity<Customer>(customerService.getCustomerById(id),HttpStatus.OK);
	}
	@GetMapping("/name/{name}")
	public List<Customer> getCustomerByName(@RequestParam(value = "name") String name){
		return customerService.getCustomerByName(name);
	}
	
	  @DeleteMapping("/id/{id}")
	  public ResponseEntity<String> deleteCustomerById(@PathVariable("id") BigInteger id){
		  customerService.deleteCustomerById(id);
		  return new ResponseEntity<String>("Deleted succesfully",HttpStatus.OK);
	  }
	  @PutMapping("/id/{id}")
	  public ResponseEntity<Customer> updateCustomerById(@PathVariable("id")BigInteger id, @RequestBody Customer customer){
		  return new ResponseEntity<Customer>(customerService.updateCustomerById(id,customer),HttpStatus.OK);
	  }
	 
}
