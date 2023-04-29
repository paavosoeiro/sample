package com.poc.sampleservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc.sampleservice.entity.Sample;

public interface SampleRepository extends MongoRepository<Sample, String> {
    
}
