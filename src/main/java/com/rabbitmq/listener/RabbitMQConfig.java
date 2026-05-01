package com.rabbitmq.listener;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static final String MY_QUEUE = "MyQueue";

    @Bean
    public Queue myQueue() {
        return new Queue(MY_QUEUE, true);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory =
                new CachingConnectionFactory("localhost");

        factory.setUsername("guest");
        factory.setPassword("guest");

        return factory;
    }

    @Bean
    public MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container =
                new SimpleMessageListenerContainer();

        container.setConnectionFactory(connectionFactory());
        container.setQueues(myQueue());
        container.setMessageListener(new RabbitmqListener());

        return container;
    }
}