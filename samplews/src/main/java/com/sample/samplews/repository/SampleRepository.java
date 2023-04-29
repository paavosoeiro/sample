package com.sample.samplews.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sample.paavo.samples.Sample;

@Component
public class SampleRepository {
    private static final Map<Integer, Sample> samples = new HashMap<>();

    @PostConstruct
    public void initData() {
        Sample sample1 = new Sample();
        sample1.setId(1);
        sample1.setName("Sample");

        samples.put(1, sample1);
    }

    public Sample getSample(int id) {
        return samples.get(id);
    }

    public List<Sample> getSamples() {
        return new ArrayList<>(samples.values());
    }

    public void addSample(Sample sample) {
        samples.put(sample.getId(), sample);
    }
}
