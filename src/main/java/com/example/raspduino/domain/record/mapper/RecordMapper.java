package com.example.raspduino.domain.record.mapper;

import com.example.raspduino.domain.record.dto.RecordDto;
import com.example.raspduino.domain.record.entity.RecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by hirri on 2018-12-09.
 */
@Mapper
public interface RecordMapper {

    RecordMapper INSTANCE = Mappers.getMapper( RecordMapper.class );

    RecordEntity dtoToEntity(RecordDto source);
    RecordDto entityToDto(RecordEntity destination);
}
