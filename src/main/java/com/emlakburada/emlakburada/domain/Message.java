package com.emlakburada.emlakburada.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    private String id;
    private String title;
    private String description;
    private LocalDateTime sentDate;
    private LocalDateTime readDate;
    private Boolean isSeen;
    private User sender;
    private User receiver;

    public Message(String title, String description) {
        this.title = title;
        this.description = description;
    }
}