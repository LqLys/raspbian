package com.example.raspduino.resource;

/**
 * Created by hirri on 2018-12-15.
 */
public class MessageRequestDto {

    private String message;


    public MessageRequestDto(String message) {
        this.message = message;
    }

    public MessageRequestDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
