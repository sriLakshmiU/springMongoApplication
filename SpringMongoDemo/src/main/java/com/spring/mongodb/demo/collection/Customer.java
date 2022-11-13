package com.spring.mongodb.demo.collection;

import java.math.BigInteger;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "customers")
public class Customer {
	
	@Transient
    public static final String SEQUENCE_NAME = "customers_sequence";
	@Id
	private BigInteger id;
	private String name;
	private Integer phone;
	private String address;
}
