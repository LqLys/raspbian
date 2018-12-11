package com.example.raspduino.domain.record.service;

import com.example.raspduino.domain.record.dto.RecordDto;
import com.example.raspduino.domain.record.entity.RecordEntity;
import com.example.raspduino.domain.record.mapper.RecordMapper;
import com.example.raspduino.domain.record.repository.RecordRepository;
import org.springframework.stereotype.Service;

/**
 * Created by hirri on 2018-12-09.
 */
@Service
public class RecordService {


    private final RecordRepository recordRepository;

    private final RecordMapper recordMapper;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
        this.recordMapper = RecordMapper.INSTANCE;
    }

    public void createRecord(RecordDto recordDto){
        RecordEntity recordEntity = recordMapper.dtoToEntity(recordDto);

        recordRepository.save(recordEntity);

    }

}
