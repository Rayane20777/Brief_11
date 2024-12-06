package com.example.brief_11.service.inpl;

import com.example.brief_11.dto.request.UserRequestDTO;
import com.example.brief_11.dto.response.UserResponseDTO;
import com.example.brief_11.entity.User;
import com.example.brief_11.mapper.UserMapper;
import com.example.brief_11.repository.UserRepository;
import com.example.brief_11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        User user = userMapper.userRequestDTOToUser(userRequestDTO);
        userRepository.save(user);
        return userMapper.userToUserResponseDTO(user);
    }
}
