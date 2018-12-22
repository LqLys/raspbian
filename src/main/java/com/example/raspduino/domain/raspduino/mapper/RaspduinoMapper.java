package com.example.raspduino.domain.raspduino.mapper;

import com.example.raspduino.domain.raspduino.dto.RaspduinoDto;
import com.example.raspduino.domain.raspduino.entity.RaspduinoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RaspduinoMapper {

    RaspduinoMapper INSTANCE = Mappers.getMapper( RaspduinoMapper.class );

    RaspduinoEntity dtoToEntity(RaspduinoDto source);
    RaspduinoDto entityToDto(RaspduinoEntity destination);
}
