package com.poc.sampleservice.repository.sequence;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SequenceException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public SequenceException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
    
}
