package com.example.brief_11.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class UserRequestDTO {
    @NotEmpty(message = "Login cannot be empty")
    private String login;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    private Boolean active;
    private String role;
}
