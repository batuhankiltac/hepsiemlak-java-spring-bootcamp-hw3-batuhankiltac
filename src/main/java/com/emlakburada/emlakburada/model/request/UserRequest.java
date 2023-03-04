package com.emlakburada.emlakburada.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRequest {

    private Integer userId;
    private String name;
    private String email;
}