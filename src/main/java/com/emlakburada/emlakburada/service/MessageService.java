package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.config.EmailConfig;
import com.emlakburada.emlakburada.converter.MessageConverter;
import com.emlakburada.emlakburada.domain.Message;
import com.emlakburada.emlakburada.model.request.MessageRequest;
import com.emlakburada.emlakburada.model.response.MessageResponse;
import com.emlakburada.emlakburada.queue.QueueService;
import com.emlakburada.emlakburada.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final QueueService queueService;
    private final MessageConverter messageConverter;

    public MessageResponse createMessage(MessageRequest messageRequest) {
        Message message = messageRepository.saveMessage(messageConverter.convert(messageRequest));
        EmailService emailService = new EmailService(new EmailConfig());
        queueService.sendMessage(emailService);
        return messageConverter.convert(message);
    }

    public Set<MessageResponse> getAllMessages() {
        Set<MessageResponse> messageList = new HashSet<>();
        for (Message message : messageRepository.findAllMessages()) {
            messageList.add(messageConverter.convert(message));
        }
        return messageList;
    }

    public MessageResponse getMessageById(Integer id) {
        Message message = messageRepository.findMessageById(id);
        return messageConverter.convert(message);
    }
}