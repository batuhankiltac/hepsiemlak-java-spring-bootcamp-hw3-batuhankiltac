package com.emlakburada.emlakburada.domain;

import com.emlakburada.emlakburada.domain.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private UserType userType;
    private Integer userId;
    private String name;
    private String email;
    private String photo;
    private String bio;
    private Set<Advert> favorites = new HashSet<>();
    private List<Advert> publishedAdverts = new ArrayList<>();
    private List<Message> messageBox;

    public User(UserType userType, String name, String email) {
        this.userType = userType;
        this.name = name;
        this.email = email;
    }
}