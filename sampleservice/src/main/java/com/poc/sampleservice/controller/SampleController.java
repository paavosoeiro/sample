package com.poc.sampleservice.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.sampleservice.model.SampleDto;
import com.poc.sampleservice.service.SampleService;

@RequestMapping("/sample")
@RestController
public class SampleController {

    private SampleService sampleService;

    public SampleController(@Qualifier("sampleServiceImpl") SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping
    public ResponseEntity<List<SampleDto>> getSamples() {
        return ResponseEntity.ok(sampleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SampleDto> getSample(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(sampleService.getSample(id));
    }

    @PostMapping
    public ResponseEntity<Void> addSample(@RequestBody SampleDto sample) {
        sampleService.add(sample);
        return ResponseEntity.created(URI.create("/sample/" + sample.getId())).build();
    }
    
}
