package com.example.brief_11.dto.response;

import java.util.UUID;

public class UserResponseDTO {
    private UUID id;
    private String login;
    private Boolean active;
    private RoleResponseDTO role;
}
