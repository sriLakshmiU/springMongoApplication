package com.spring.mongodb.demo.service;

import java.math.BigInteger;
import java.util.Objects;

import com.spring.mongodb.demo.collection.DatabaseSequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorService {
	
	
	private MongoOperations mongoOperations;
	
	@Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
	
	public BigInteger generateSequence(String seqName) {
	    DatabaseSequence counter = mongoOperations.findAndModify(Query.query(where("_id").is(seqName)),
	      new Update().inc("seq",1), options().returnNew(true).upsert(true),
	      DatabaseSequence.class);
	    return !Objects.isNull(counter) ? counter.getSeq() : BigInteger.valueOf(1);
	}
}
