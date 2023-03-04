package com.emlakburada.emlakburada.model.response;

import com.emlakburada.emlakburada.domain.Advert;
import com.emlakburada.emlakburada.domain.Message;
import com.emlakburada.emlakburada.domain.enums.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class UserResponse {

    private UserType userType;
    private Integer userId;
    private String name;
    private String email;
    private String photo;
    private String bio;
    private Set<Advert> favorites;
    private List<Advert> publishedAdverts;
    private List<Message> messageBox;
}