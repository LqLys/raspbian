package com.example.raspduino.domain.record.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by hirri on 2018-12-09.
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "record")
public class RecordEntity {
    @Id
    private String id;
    private Integer light;
    private Double humidity;
    private Double temperature;
    private Integer distance;
    private LocalDateTime measuredAt;




}
