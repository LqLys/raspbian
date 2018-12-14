package com.example.raspduino.domain.record.repository;

import com.example.raspduino.domain.record.entity.RecordEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by hirri on 2018-12-09.
 */
public interface RecordRepository extends MongoRepository<RecordEntity, Long> {
    List<RecordEntity> findAllByMeasuredAtBetween(LocalDateTime dateFrom, LocalDateTime dateTo);

    List<RecordEntity> findTop100ByMeasuredAtBetweenOrderByMeasuredAtDesc(LocalDateTime dateFrom, LocalDateTime dateTo);
}
