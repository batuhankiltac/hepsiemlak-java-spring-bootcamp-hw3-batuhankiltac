package com.emlakburada.emlakburada.converter;

import com.emlakburada.emlakburada.domain.Message;
import com.emlakburada.emlakburada.model.request.MessageRequest;
import com.emlakburada.emlakburada.model.response.MessageResponse;
import org.springframework.stereotype.Component;

@Component
public class MessageConverter {

    public MessageResponse convert(Message message) {
        return MessageResponse.builder()
                .title(message.getTitle())
                .description(message.getDescription())
                .isSeen(message.getIsSeen())
                .build();
    }

    public Message convert(MessageRequest request) {
        return Message.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
    }
}
