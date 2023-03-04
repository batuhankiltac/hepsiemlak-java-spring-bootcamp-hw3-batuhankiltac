package com.emlakburada.emlakburada.converter;

import com.emlakburada.emlakburada.domain.User;
import com.emlakburada.emlakburada.model.request.UserRequest;
import com.emlakburada.emlakburada.model.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserResponse convert(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public User convert(UserRequest request) {
        User user = new User();
        user.setUserId(request.getUserId());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        return user;
    }
}
