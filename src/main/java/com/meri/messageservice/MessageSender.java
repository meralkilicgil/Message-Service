package com.meri.messageservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    public final RabbitTemplate rabbitTemplate;

    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageMeri(String message){
        rabbitTemplate.convertAndSend("meriExchange", "topic.meri", message);
    }

    public void sendMessageEfo(String message){
        rabbitTemplate.convertAndSend("efoExchange", "topic.efo", message);
    }
}
