package com.sample.sampleclient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.sampleclient.client.SampleServiceClient;
import com.sample.sampleclient.model.Sample;

@Service
public class SimpleClientService {

    private SampleServiceClient serviceClient;

    public SimpleClientService(SampleServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    public List<Sample> getAllSamples() {
        return serviceClient.getSamples();
    }

    public void addSample(Sample sample){
        serviceClient.addSample(sample);
    }
}
