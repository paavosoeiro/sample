package com.poc.sampleservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.sampleservice.entity.Sample;
import com.poc.sampleservice.model.SampleDto;
import com.poc.sampleservice.repository.SampleRepository;
import com.poc.sampleservice.repository.sequence.dao.SequencedDao;

@Service
public class SampleServiceDb implements SampleService {

    private SampleRepository sampleRepository;

    private SequencedDao sequencedDao;

    public SampleServiceDb(SampleRepository sampleRepository, SequencedDao sequencedDao) {
        this.sampleRepository = sampleRepository;
        this.sequencedDao = sequencedDao;
    }

    @Override
    public List<SampleDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public SampleDto getSample(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSample'");
    }

    @Override
    public SampleDto add(SampleDto sampleDto) {
        Sample sample = sampleDto.toSample();
        sample.setId(sequencedDao.getNextSequenceId("sampleseq"));
        sampleRepository.save(sample);
        return SampleDto.of(sample);
    }

}
