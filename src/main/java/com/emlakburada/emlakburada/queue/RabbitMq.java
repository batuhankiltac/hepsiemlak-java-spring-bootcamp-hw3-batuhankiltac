package com.emlakburada.emlakburada.queue;

import com.emlakburada.emlakburada.config.RabbitMqConfig;
import com.emlakburada.emlakburada.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMq implements QueueService {
    private final AmqpTemplate rabbitTemplate;
    private final RabbitMqConfig config;

    @Override
    public void sendMessage(EmailService message) {
        rabbitTemplate.convertAndSend(config.getExchange(), config.getRoutingkey(), message);
    }
}