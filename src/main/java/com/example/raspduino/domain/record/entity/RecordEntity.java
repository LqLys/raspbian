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


@Document(collection = "record")
public class RecordEntity {
    @Id
    private String id;
    private String robotId;
    private Integer light;
    private Double voltage;
    private Double humidity;
    private Double temperature;
    private Integer distance;
    private LocalDateTime measuredAt;


    public RecordEntity(String id, String robotId, Integer light, Double voltage, Double humidity, Double temperature, Integer distance, LocalDateTime measuredAt) {
        this.id = id;
        this.robotId = robotId;
        this.light = light;
        this.voltage = voltage;
        this.humidity = humidity;
        this.temperature = temperature;
        this.distance = distance;
        this.measuredAt = measuredAt;
    }

    public RecordEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Double getVoltage() {
        return voltage;
    }

    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public LocalDateTime getMeasuredAt() {
        return measuredAt;
    }

    public void setMeasuredAt(LocalDateTime measuredAt) {
        this.measuredAt = measuredAt;
    }
}
