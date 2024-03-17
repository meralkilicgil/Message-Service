package com.meri.messageservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @RabbitListener(queues = "meriQueue")
    public void receiveMessageMeri(String message){
        System.out.println("Received message from meriQueue: " + message);
    }


    @RabbitListener(queues = "efoQueue")
    public void receiveMessageEfo(String message){
        System.out.println("Received message from efoQueue: " + message);
    }
}
