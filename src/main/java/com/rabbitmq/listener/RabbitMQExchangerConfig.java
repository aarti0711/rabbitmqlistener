package com.rabbitmq.listener;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangerConfig {
    @Bean
    Exchange exampleExchange(){
        return new TopicExchange("Exchnage example") ;
    }
    @Bean
    Exchange example2ndExchange(){
        return ExchangeBuilder.directExchange("Example 2nd Exchange")
                .autoDelete()
                .internal()
                .build();
    }
    @Bean
    Exchange newExchange(){
        return ExchangeBuilder.topicExchange("Topic Exchange")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }
    @Bean
    Exchange fanoutExchange(){
        return ExchangeBuilder.fanoutExchange("FanOut Exchane")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }
    @Bean
    Exchange headerExchange(){
        return ExchangeBuilder.headersExchange("Header Exchane")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }
}
