package com.poc.sampleservice.entity;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sample {
    
    @Id
    private String identity;
    private Integer id;
    private String name;
}
