package com.example.raspduino.resource;

import com.example.raspduino.domain.raspduino.dto.RaspduinoDto;
import com.example.raspduino.domain.raspduino.service.RaspduinoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/raspduino")
public class RaspduinoResource {

    private final RaspduinoService raspduinoService;

    public RaspduinoResource(RaspduinoService raspduinoService) {
        this.raspduinoService = raspduinoService;
    }

    @PostMapping
    public void createRaspduino(@RequestBody RaspduinoDto raspduinoDto){
        raspduinoService.createRaspduino(raspduinoDto);
    }
}
