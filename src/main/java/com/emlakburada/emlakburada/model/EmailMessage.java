package com.emlakburada.emlakburada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailMessage {
    private String email;

    @Override
    public String toString() {
        return "EmailMessage [email=" + email + "]";
    }
}