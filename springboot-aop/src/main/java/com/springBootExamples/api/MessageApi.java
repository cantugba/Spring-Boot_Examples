package com.springBootExamples.api;

import com.springBootExamples.service.MessageService;
import com.springBootExamples.service.SecondMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/message")
public class MessageApi {
    @Autowired
    private MessageService messageService;

    @Autowired
    private SecondMessageService secondMessageService;

    @PostMapping
    public ResponseEntity<String> showMessage(@RequestBody String message) {
        secondMessageService.message(message);
        return ResponseEntity.ok(messageService.sendMessage(message));
    }
}
