package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.converter.UserConverter;
import com.emlakburada.emlakburada.domain.User;
import com.emlakburada.emlakburada.domain.enums.UserType;
import com.emlakburada.emlakburada.model.request.UserRequest;
import com.emlakburada.emlakburada.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserConverter userConverter;

    @Test
    public void it_should_create_user() {
        // Given
        final UserRequest userRequest = UserRequest.builder().build();
        final User user = User.builder().build();
        when(userConverter.convert(userRequest)).thenReturn(user);

        // When
        userService.createUser(userRequest);

        // Then
        verify(userConverter).convert(userRequest);
    }

    @Test
    public void it_should_get_all_users() {
        // Given
        final User user1 = User.builder()
                .userId(1)
                .name("test-name1")
                .userType(UserType.INDIVIDUAL)
                .build();
        final User user2 = User.builder()
                .userId(2)
                .name("test-name2")
                .userType(UserType.CORPORATE)
                .build();
        List<User> users = Arrays.asList(user1, user2);

        // When
        userService.getAllUsers();

        // Then
        verify(userRepository).findAllUsers();
        assertThat(user1.getUserId()).isNotNull();
        assertThat(users.size()).isNotZero();
    }

    @Test
    public void it_should_get_user_by_id() {
        // Given
        final Integer userId = 1;
        final User user = User.builder().build();
        when(userRepository.findUserById(userId)).thenReturn(user);

        // When
        userService.getUserById(userId);

        // Then
        verify(userRepository).findUserById(userId);
    }

    @Test
    public void it_should_get_favorites_by_user_id() {
        // Given
        final Integer userId = 1;
        final User user = User.builder().build();
        when(userRepository.findUserFavoritesById(userId)).thenReturn(user);

        // When
        userService.getUserFavoritesById(userId);

        // Then
        verify(userRepository).findUserFavoritesById(userId);
    }
}
