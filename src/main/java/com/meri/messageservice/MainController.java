package com.meri.messageservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    public final MessageSender messageSender;

    public MainController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @GetMapping("/sendMessage/meri")
    public void sendMessage(@RequestParam(value = "message") String message){
        messageSender.sendMessageMeri(message);
    }


    @GetMapping("/sendMessage/efo")
    public void sendMessageEfo(@RequestParam(value = "message") String message){
        messageSender.sendMessageEfo(message);
    }
}
