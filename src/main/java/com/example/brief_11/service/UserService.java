package com.example.brief_11.service;

import com.example.brief_11.dto.request.UserRegistrationDTO;
import com.example.brief_11.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO registerUser(UserRegistrationDTO registrationDTO);
}
