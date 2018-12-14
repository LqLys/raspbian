package com.example.raspduino.resource;

import java.util.List;

/**
 * Created by hirri on 2018-12-12.
 */
public class DistanceChartDto {

    List<String> time;
    List<Integer> distance;

    public DistanceChartDto(List<String> time, List<Integer> distance) {
        this.time = time;
        this.distance = distance;
    }

    public DistanceChartDto() {
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
}
