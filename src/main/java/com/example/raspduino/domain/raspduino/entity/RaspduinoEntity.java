package com.example.raspduino.domain.raspduino.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("raspduino")
public class RaspduinoEntity {

    @Id
    private String id;
    private String ip;
    private Integer port;
    private String name;
    private Integer measureInterval;


    public RaspduinoEntity(String id, String ip, Integer port, String name, Integer measureInterval) {
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.name = name;
        this.measureInterval = measureInterval;
    }

    public RaspduinoEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMeasureInterval() {
        return measureInterval;
    }

    public void setMeasureInterval(Integer measureInterval) {
        this.measureInterval = measureInterval;
    }
}
