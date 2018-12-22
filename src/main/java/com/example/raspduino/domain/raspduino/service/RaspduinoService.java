package com.example.raspduino.domain.raspduino.service;

import com.example.raspduino.domain.raspduino.dto.RaspduinoDto;
import com.example.raspduino.domain.raspduino.mapper.RaspduinoMapper;
import com.example.raspduino.domain.raspduino.repository.RaspduinoRepository;
import org.springframework.stereotype.Service;

@Service
public class RaspduinoService {

    private final RaspduinoRepository raspduinoRepository;

    private final RaspduinoMapper raspduinoMapper;


    public RaspduinoService(RaspduinoRepository raspduinoRepository) {
        this.raspduinoRepository = raspduinoRepository;
        this.raspduinoMapper = RaspduinoMapper.INSTANCE;
    }

    public void createRaspduino(RaspduinoDto raspduinoDto){
        raspduinoRepository.save(raspduinoMapper.dtoToEntity(raspduinoDto));


    }
}
