package com.poc.sampleservice.model;

import com.poc.sampleservice.entity.Sample;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SampleDto {

    private Integer id;
    private String name;

    public static SampleDto of(Sample sample) {
        return SampleDto.builder().id(sample.getId()).name(sample.getName()).build();
    }

    public Sample toSample() {
        return Sample.builder().id(this.id).name(this.name).build();
    }

}
