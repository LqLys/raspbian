package com.example.raspduino.resource;

import com.example.raspduino.domain.record.dto.RecordDto;
import com.example.raspduino.domain.record.service.RecordService;
import com.example.raspduino.udp.EchoClient;
import com.example.raspduino.udp.EchoServer;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

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
