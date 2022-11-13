package com.spring.mongodb.demo.listener;

import java.math.BigInteger;

import com.spring.mongodb.demo.collection.Customer;
import com.spring.mongodb.demo.service.SequenceGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class UserModelListener extends AbstractMongoEventListener<Customer> {
	
	private SequenceGeneratorService sequenceGeneratorService;
	@Autowired
	public UserModelListener(SequenceGeneratorService sequenceGeneratorService) {
		super();
		this.sequenceGeneratorService = sequenceGeneratorService;
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Customer> event) {
	    if (event.getSource().getId().compareTo(BigInteger.valueOf(1))<1) {
	        event.getSource().setId(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME));
	    }
	}
}
