package com.springBootExamples.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String sendMessage(String param) {
        System.out.println("method send message" + param);
        return param;
    }
}
