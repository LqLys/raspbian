package com.example.raspduino.domain.record.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by hirri on 2018-12-09.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecordDto {

    public String id;
    public Double temperature;
    private LocalDateTime measuredAt;
}
