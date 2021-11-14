package com.springBootExamples.ws.controller;

import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.message.SimpleMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.messaging.handler.annotation.MessageMapping;

@Controller
@CrossOrigin
public class ChatController {
    // ????????
    @Autowired
    //private SimpleMessaginTemplate simpleMessage;

    @MessageMapping("/chat")
    //@SendTo("/topic")
    //@SendToUser(")
    public void chatEndpoint(@Payload WsMessage wsMessage) {
        System.out.println(wsMessage);
        //simpleMessage.convertAndSend("/topic", wsMessage);

    }

}
