package com.emlakburada.emlakburada.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageRequest {

    private String title;
    private String description;
}