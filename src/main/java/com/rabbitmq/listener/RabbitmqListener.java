package com.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitmqListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("Message =[" + new String(message.getBody())+ "]");
    }
}
