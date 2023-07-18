package com.michwierzch.ChatterBox.service;

import lombok.*;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

public class RegistrationRequest {
    private final String username;
    private final String email;
    private final String password;
}
