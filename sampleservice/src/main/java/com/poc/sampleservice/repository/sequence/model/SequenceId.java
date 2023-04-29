package com.poc.sampleservice.repository.sequence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "sequence")
public class SequenceId {
    
    @Id
    private String id;

    private int seq;
}
