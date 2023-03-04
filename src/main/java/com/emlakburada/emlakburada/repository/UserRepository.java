package com.emlakburada.emlakburada.repository;

import com.emlakburada.emlakburada.domain.User;
import com.emlakburada.emlakburada.domain.enums.UserType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private static final List<User> userList = new ArrayList<>();

    private static User prepareUser(Integer userId, String name) {
        User user = new User();
        user.setUserType(UserType.INDIVIDUAL);
        user.setUserId(userId);
        user.setName(name);
        return user;
    }

    static {
        userList.add(prepareUser(1, "Batuhan"));
        userList.add(prepareUser(2, "Ahmet"));
        userList.add(prepareUser(3, "Mehmet"));
    }

    public User saveUser(User user) {
        userList.add(user);
        return user;
    }

    public List<User> findAllUsers() {
        return userList;
    }

    public User findUserById(Integer userId) {
        return userList.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findAny()
                .orElse(new User());
    }

    public User findUserFavoritesById(Integer id) {
        return userList.stream()
                .filter(user -> user.getUserId().equals(id))
                .findFirst()
                .orElse(null);
    }
}