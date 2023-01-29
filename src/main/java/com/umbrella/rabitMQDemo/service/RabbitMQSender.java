package com.umbrella.rabitMQDemo.service;

import com.umbrella.rabitMQDemo.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${demo.rabbitmq.exchange}")
    private String exchange;

    @Value("${demo.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee employeeName) {
        /**
         * The convertAndSend method converts the java object to an amqp message,
         * and then sends this message via the routing key to the exchange.
         */
        amqpTemplate.convertAndSend("techgeeknextExchange", "techgeeknext", employeeName);
        System.out.println("Send msg = " + employeeName);
    }
}
