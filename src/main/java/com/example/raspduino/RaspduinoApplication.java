package com.example.raspduino;

import com.example.raspduino.udp.EchoServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.net.SocketException;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class RaspduinoApplication {

	public static void main(String[] args) throws SocketException {
		SpringApplication.run(RaspduinoApplication.class, args);

	}
}
