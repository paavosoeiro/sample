package com.poc.sampleservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.sampleservice.model.SampleDto;
import com.poc.sampleservice.model.SampleNotFoundException;

@Service
public class SampleServiceImpl implements SampleService {

    private List<SampleDto> samples;

    private static int id = 0;

    public SampleServiceImpl() {
        samples = new ArrayList<>();
    }

    @Override
    public List<SampleDto> getAll() {
        return samples;
    }

    @Override
    public SampleDto getSample(Integer id) {
        return samples.stream().filter(x -> id == x.getId()).findAny()
                .orElseThrow(() -> new SampleNotFoundException(id));
    }

    @Override
    public SampleDto add(SampleDto sample) {
        sample.setId(++id);
        samples.add(sample);
        return sample;
    }

}
