package com.example.raspduino.resource;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by hirri on 2018-12-12.
 */
public class TemperatureChartDto {

    List<String> time;
    List<Double> temperature;


    public TemperatureChartDto(List<String> time, List<Double> temperature) {
        this.time = time;
        this.temperature = temperature;
    }

    public TemperatureChartDto() {
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Double> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<Double> temperature) {
        this.temperature = temperature;
    }
}
