package com.sample.sampleclient.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sample.sampleclient.model.Sample;

@FeignClient(name = "sampleclient", url = "http://localhost:8080")
public interface SampleServiceClient {
    
    @GetMapping("/sample")
    public List<Sample> getSamples();

    @PostMapping("/sample")
    public void addSample(@RequestBody Sample sample);
}
