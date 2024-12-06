package com.example.brief_11.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserResponseDTO {
    private UUID id;
    private String login;
    private Boolean active;
    private RoleResponseDTO role;
}
