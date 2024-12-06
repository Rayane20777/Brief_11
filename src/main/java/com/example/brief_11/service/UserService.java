package com.example.brief_11.service;

import com.example.brief_11.dto.request.UserRequestDTO;
import com.example.brief_11.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

}
