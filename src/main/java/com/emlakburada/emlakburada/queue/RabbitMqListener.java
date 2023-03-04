package com.emlakburada.emlakburada.queue;

import com.emlakburada.emlakburada.model.EmailMessage;
import com.emlakburada.emlakburada.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMqListener {
    private final EmailService emailService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveMessage(EmailMessage message) {
        log.info(message.toString());
        emailService.send(message.getEmail());
    }
}