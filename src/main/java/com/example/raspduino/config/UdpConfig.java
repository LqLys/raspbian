package com.example.raspduino.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;

/**
 * Created by hirri on 2018-12-09.
 */
@Configuration
public class UdpConfig {

//    @Bean
//    public IntegrationFlow processUniCastUdpMessage() {
//        UnicastReceivingChannelAdapter messageProducer = new UnicastReceivingChannelAdapter(4446);
//        messageProducer.setLengthCheck(false);
//
//        return IntegrationFlows
//                .from(messageProducer)
//                .handle("UDPServer", "handleMessage")
//                .get();
//    }
}
