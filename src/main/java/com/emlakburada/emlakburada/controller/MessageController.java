package com.emlakburada.emlakburada.controller;

import com.emlakburada.emlakburada.model.request.MessageRequest;
import com.emlakburada.emlakburada.model.response.MessageResponse;
import com.emlakburada.emlakburada.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/messages")
public class MessageController {
    private final MessageService messageService;

    @PostMapping
    public MessageResponse createMessage(@RequestBody MessageRequest request) {
        return messageService.createMessage(request);
    }

    @GetMapping
    public Set<MessageResponse> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping(value = "/{id}")
    public MessageResponse getMessageById(@PathVariable Integer id) {
        return messageService.getMessageById(id);
    }
}