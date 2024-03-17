package com.meri.messageservice;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "meriQueue";
    public static final String EXCHANGE_NAME =  "meriExchange";

    @Bean
    public Queue meriQueue(){
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Exchange meriExchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Exchange efoExchange(){
        return new TopicExchange("efoExchange");
    }

    @Bean
    public Binding meriBinding(){
        return BindingBuilder.bind(meriQueue()).to(meriExchange()).with("topic.meri").noargs();
    }

    @Bean
    public Binding efoBinding(){
        return BindingBuilder.bind(meriQueue()).to(efoExchange()).with("topic.efo").noargs();
    }
}
