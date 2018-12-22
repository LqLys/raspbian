package com.example.raspduino.udp;

import com.example.raspduino.domain.record.entity.RecordEntity;
import com.example.raspduino.domain.record.repository.RecordRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hirri on 2018-12-09.
 */
@Component
public class EchoServer extends Thread {

    private RecordRepository recordRepository;

    private DatagramSocket socket;
    public boolean running;
    private byte[] buf = new byte[256];
    int counter = 0;

    public EchoServer(RecordRepository recordRepository) throws SocketException {
        socket = new DatagramSocket(4446);
        this.recordRepository = recordRepository;
    }

    public void run() {
        running = true;

        while (running) {

            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            String received
                    = new String(packet.getData(), 0, packet.getLength());
            System.out.println(received);
            List<String> params = Arrays.asList(received.split(";"));
            List<String[]> splitParams = params.stream().map(str->str.split("=")).collect(Collectors.toList());

            String prefix = splitParams.get(0)[0];
            if(prefix.equals("data")){
                String robotId = splitParams.get(1)[1];
                Integer light = Integer.parseInt(splitParams.get(2)[1]);
                Double voltage = Double.parseDouble(splitParams.get(3)[1]);
                Double temperature = Double.parseDouble(splitParams.get(4)[1]);
                Double humidity = Double.parseDouble(splitParams.get(5)[1]);
                LocalDateTime time = formatDate(splitParams.get(6)[1]);
                String last = splitParams.get(7)[1];

                int indexOf = last.indexOf('\r');
                Integer dist = Integer.parseInt(last.substring(0,indexOf));

                recordRepository.save(new RecordEntity(null,robotId, light, voltage,humidity,temperature,dist,time));
                if (counter == 9){
                    counter = 0;
                }
            }else{
                System.out.println("prefix is: " + prefix);
            }



            if (received.equals("end")) {
                running = false;
                continue;
            }
            buf = new byte[256];
//            try {
//                this.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            try {
//                socket.send(packet);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        socket.close();
    }

    public void stopServer(){
        running = false;
    }

    private LocalDateTime formatDate(String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        String[] date = time.split("-");
        sb.append("20").append(date[0]);
        for(int i = 1; i<date.length; i++){
            sb.append(date[i].length() == 1 ? "-0" : "-").append(date[i]);
        }
        String formattedString = sb.toString();
        date = formattedString.split("-");
        sb = new StringBuilder();
        sb.append(date[0]).append("-").append(date[1]).append("-").append(date[2]).append(" ")
                .append(date[3]).append(":").append(date[4]).append(":").append(date[5]);

        LocalDateTime localDateTime = LocalDateTime.parse(sb.toString(),formatter);
        return localDateTime;

    }
}
