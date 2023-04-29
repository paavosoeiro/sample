package com.poc.sampleservice.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.sampleservice.model.SampleDto;
import com.poc.sampleservice.service.SampleService;

@RequestMapping("/v2/sample")
@RestController
public class SampleControllerV2 {

    private SampleService sampleService;

    public SampleControllerV2(@Qualifier("sampleServiceDb") SampleService sampleService) {
        this.sampleService = sampleService;
    }
    
    @PostMapping
    public ResponseEntity<Void> addSample(@RequestBody SampleDto sample) {
        var sampleResponse = sampleService.add(sample);
        return ResponseEntity.created(URI.create("/sample/" + sampleResponse.getId())).build();
    }
}
