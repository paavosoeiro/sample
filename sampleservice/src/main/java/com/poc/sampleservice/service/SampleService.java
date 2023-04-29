package com.poc.sampleservice.service;

import java.util.List;

import com.poc.sampleservice.model.SampleDto;

public interface SampleService {

    List<SampleDto> getAll();

    SampleDto getSample(Integer id);

    SampleDto add(SampleDto sample);

}