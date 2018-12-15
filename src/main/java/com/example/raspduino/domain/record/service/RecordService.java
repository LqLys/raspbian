package com.example.raspduino.domain.record.service;

import com.example.raspduino.domain.record.dto.RecordDto;
import com.example.raspduino.domain.record.entity.RecordEntity;
import com.example.raspduino.domain.record.mapper.RecordMapper;
import com.example.raspduino.domain.record.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<RecordDto> getAllRecordsInTimeRange(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return recordRepository.findAllByMeasuredAtBetween(dateFrom, dateTo)
                .stream()
                .map(recordMapper::entityToDto)
                .limit(10)
                .collect(Collectors.toList());

    }

    public List<RecordDto> get100LatestRecords(){
        return recordRepository.findTop100ByMeasuredAtBetweenOrderByMeasuredAtDesc(LocalDateTime.now().minusDays(10),LocalDateTime.now())
                .stream()
                .map(recordMapper::entityToDto)
                .limit(25)
                .collect(Collectors.toList());
    }
}
