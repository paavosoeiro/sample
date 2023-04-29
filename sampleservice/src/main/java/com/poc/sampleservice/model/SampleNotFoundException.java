package com.poc.sampleservice.model;

public class SampleNotFoundException extends RuntimeException {
    public SampleNotFoundException(Integer id) {
        super("Could not find sample " + id);
    }
}
