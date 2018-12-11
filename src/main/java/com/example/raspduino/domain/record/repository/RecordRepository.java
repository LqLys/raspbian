package com.example.raspduino.domain.record.repository;

import com.example.raspduino.domain.record.entity.RecordEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by hirri on 2018-12-09.
 */
public interface RecordRepository extends MongoRepository<RecordEntity, Long> {
}
