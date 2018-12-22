package com.example.raspduino.resource;

import java.util.List;

/**
 * Created by hirri on 2018-12-15.
 */
public class ChartDataDto {
    private String robotId;
    private List<String> time;
    private List<Integer> distance;
    private List<Double> temperature;
    private List<Double> humidity;
    private List<Integer> light;
    private List<Double> voltage;


    public ChartDataDto(String robotId, List<String> time, List<Integer> distance, List<Double> temperature, List<Double> humidity, List<Integer> light, List<Double> voltage) {
        this.robotId = robotId;
        this.time = time;
        this.distance = distance;
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
        this.voltage = voltage;
    }

    public ChartDataDto() {
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Integer> getDistance() {
        return distance;
    }

    public void setDistance(List<Integer> distance) {
        this.distance = distance;
    }

    public List<Double> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<Double> temperature) {
        this.temperature = temperature;
    }

    public List<Double> getHumidity() {
        return humidity;
    }

    public void setHumidity(List<Double> humidity) {
        this.humidity = humidity;
    }

    public List<Integer> getLight() {
        return light;
    }

    public void setLight(List<Integer> light) {
        this.light = light;
    }

    public List<Double> getVoltage() {
        return voltage;
    }

    public void setVoltage(List<Double> voltage) {
        this.voltage = voltage;
    }
}


