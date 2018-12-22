package com.example.raspduino.domain.raspduino.repository;

import com.example.raspduino.domain.raspduino.entity.RaspduinoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RaspduinoRepository extends MongoRepository<RaspduinoEntity, String> {
}
