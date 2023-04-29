package com.sample.samplews.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sample.samplews.exception.SampleNotFoundException;
import com.sample.samplews.exception.ServiceFaultException;
import com.sample.samplews.repository.SampleRepository;

import sample.paavo.samples.CreateSampleRequest;
import sample.paavo.samples.CreateSampleResponse;
import sample.paavo.samples.GetAllSampleRequest;
import sample.paavo.samples.GetAllSampleResponse;
import sample.paavo.samples.GetSampleRequest;
import sample.paavo.samples.GetSampleResponse;
import sample.paavo.samples.ServiceStatus;

@Endpoint
public class SampleWebService {
    private static final String NAMESPACE_URI = "http://paavo.sample/samples";

    private SampleRepository sampleRepository;

    public SampleWebService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllSampleRequest")
    @ResponsePayload
    public GetAllSampleResponse getAllSample(@RequestPayload GetAllSampleRequest getAllSampleRequest) {
        var getAllSampleResponse = new GetAllSampleResponse();
        sampleRepository.getSamples().forEach(sample -> getAllSampleResponse.getSample().add(sample));

        return getAllSampleResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSampleRequest")
    @ResponsePayload
    public GetSampleResponse getSample(@RequestPayload GetSampleRequest getSampleRequest) {
        var getSampleResponse = new GetSampleResponse();
        var sample = sampleRepository.getSample(getSampleRequest.getId());

        if (sample == null) {
            // throw new SampleNotFoundException("Sample not found for id: " +
            // getSampleRequest.getId());
            var serviceStatus = new ServiceStatus();
            serviceStatus.setStatusCode("NOT_FOUND");
            serviceStatus.setMessage("Sample not found for id: " +
                    getSampleRequest.getId());

            throw new ServiceFaultException("ERROR", serviceStatus);
        }

        getSampleResponse.setSample(sample);

        return getSampleResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createSampleRequest")
    @ResponsePayload
    public CreateSampleResponse createSample(@RequestPayload CreateSampleRequest createSampleRequest) {
        sampleRepository.addSample(createSampleRequest.getSample());

        return new CreateSampleResponse();
    }

}
