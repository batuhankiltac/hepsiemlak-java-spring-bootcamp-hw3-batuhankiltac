/*
package com.emlakburada.emlakburada.queue;

import com.emlakburada.emlakburada.service.EmailService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
@RequiredArgsConstructor
public class ActiveMq implements QueueService {
    private final JmsTemplate jmsTemplate;
    private final Queue queue;

    @Override
    public void sendMessage(EmailService emailService) {
        jmsTemplate.convertAndSend(queue, emailService);
    }
}*/