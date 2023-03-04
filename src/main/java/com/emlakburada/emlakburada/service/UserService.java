package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.converter.UserConverter;
import com.emlakburada.emlakburada.domain.User;
import com.emlakburada.emlakburada.model.request.UserRequest;
import com.emlakburada.emlakburada.model.response.UserResponse;
import com.emlakburada.emlakburada.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserResponse createUser(UserRequest userRequest) {
        User user = userRepository.saveUser(userConverter.convert(userRequest));
        return userConverter.convert(user);
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAllUsers()
                .stream()
                .map(userConverter::convert)
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(Integer userId) {
        User user = userRepository.findUserById(userId);
        return userConverter.convert(user);
    }

    public UserResponse getUserFavoritesById(Integer id) {
        return userConverter.convert(userRepository.findUserFavoritesById(id));
    }
}