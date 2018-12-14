package com.example.raspduino.resource;

import com.example.raspduino.domain.record.dto.RecordDto;
import com.example.raspduino.domain.record.service.RecordService;
import com.example.raspduino.udp.EchoClient;
import com.example.raspduino.udp.EchoServer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hirri on 2018-12-09.
 */
@RestController("/record")
public class RecordResource {

    private final RecordService recordService;

    private final EchoServer echoServer;

    public RecordResource(RecordService recordService, EchoServer echoServer) {
        this.recordService = recordService;
        this.echoServer = echoServer;
    }


    @PostMapping("/")
    public void createRecord(@RequestBody RecordDto recordDto){
        recordService.createRecord(recordDto);
    }


    @GetMapping("/range")
    public List<RecordDto> getAllRecordsInTimeRange(@RequestParam("dateFrom") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")LocalDateTime dateFrom,
                                                    @RequestParam("dateTo") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")LocalDateTime dateTo){
        return recordService.getAllRecordsInTimeRange(dateFrom, dateTo);

    }

    @GetMapping("/top100")
    public List<RecordDto> get100LatestRecords(){
        return recordService.get100LatestRecords();
    }

    @GetMapping("/temperature")
    public TemperatureChartDto getTemperatureData(){
        List<String> time = new ArrayList<>();
        List<Double> temperature = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        recordService.get100LatestRecords().stream().forEach(recordDto ->{
            String dateTime = recordDto.getMeasuredAt().format(formatter);
            time.add(dateTime);
            temperature.add(recordDto.getTemperature());
        } );

        List<String> time2 = new ArrayList<>();
        List<Double> temperature2 = new ArrayList<>();
//        temperature2 = temperature.stream().limit(10).collect(Collectors.toList());
//        time2 = time.stream().limit(10).collect(Collectors.toList());

        return new TemperatureChartDto(time, temperature);
    }

    @GetMapping("/distance")
    public DistanceChartDto getDistanceData(){
        List<String> time = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        recordService.get100LatestRecords().stream()
                .filter(record-> record.getDistance()<2000)
                .forEach(recordDto ->{
            String dateTime = recordDto.getMeasuredAt().format(formatter);
            time.add(dateTime);
            distance.add(recordDto.getDistance());
        } );
        return new DistanceChartDto(time, distance);
    }

    @GetMapping("/chartData")
    public ChartDataDto getChartData(){
        List<String> time = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();
        List<Double> humidity = new ArrayList<>();
        List<Double> temperature = new ArrayList<>();
        List<Integer> light = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<RecordDto> records = recordService.get100LatestRecords();
        String robotId = records.get(0).getRobotId();
        records.stream()
                .filter(record -> record.getDistance() < 2000)
                .forEach(record ->{
                    String dateTime = record.getMeasuredAt().format(formatter);
                    time.add(dateTime);
                    distance.add(record.getDistance());
                    humidity.add(record.getHumidity());
                    temperature.add(record.getTemperature());
                    light.add(record.getLight());

                });
        return new ChartDataDto(robotId,time,distance,temperature, humidity,light);

    }




    @GetMapping("/udp")
    public void udpOn() {
        echoServer.start();
        System.out.println("waiting");

//        UnicastSendingMessageHandler handler =
//                new UnicastSendingMessageHandler("192.168.0.19", 10000);
//
//        String payload = "Hello world";
//        handler.handleMessage(MessageBuilder.withPayload(payload).build());
    }

    @GetMapping("/udpOff")
    public void udpOff() {
        echoServer.stopServer();
        System.out.println("waiting");

//        UnicastSendingMessageHandler handler =
//                new UnicastSendingMessageHandler("192.168.0.19", 10000);
//
//        String payload = "Hello world";
//        handler.handleMessage(MessageBuilder.withPayload(payload).build());
    }

    @PostMapping("/message/{msg}")
    public void sendMessage(@PathVariable("msg")String msg) throws IOException {
        EchoClient c = new EchoClient();
        c.sendEcho(msg);
        c.close();
    }


}
