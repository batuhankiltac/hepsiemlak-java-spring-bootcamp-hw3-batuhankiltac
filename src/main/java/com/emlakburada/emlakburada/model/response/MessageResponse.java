package com.emlakburada.emlakburada.model.response;

import com.emlakburada.emlakburada.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MessageResponse {

    private String title;
    private String description;
    private LocalDateTime sentDate;
    private LocalDateTime readDate;
    private Boolean isSeen;
    private User sender;
    private User receiver;
}