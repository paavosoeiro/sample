package com.sample.sampleclient.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.sampleclient.model.Sample;
import com.sample.sampleclient.service.SimpleClientService;

@RequestMapping("/client")
@RestController
public class SampleClientController {

    private SimpleClientService clientService;

    public SampleClientController(SimpleClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Sample>> getAll() {
        return ResponseEntity.ok(clientService.getAllSamples());
    }

    @PostMapping
    public ResponseEntity<Void> addSample(@RequestBody Sample sample){
        clientService.addSample(sample);
        return ResponseEntity.created(URI.create("/client/" + sample.getId())).build();
    }
    
}
