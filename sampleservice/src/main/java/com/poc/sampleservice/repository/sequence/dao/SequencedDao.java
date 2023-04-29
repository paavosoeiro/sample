package com.poc.sampleservice.repository.sequence.dao;

import com.poc.sampleservice.repository.sequence.SequenceException;

public interface SequencedDao {
    int getNextSequenceId(String key) throws SequenceException;
}
