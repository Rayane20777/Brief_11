package com.example.brief_11.service.inpl;

import com.example.brief_11.dto.request.UserRequestDTO;
import com.example.brief_11.dto.response.UserResponseDTO;
import com.example.brief_11.entity.Role;
import com.example.brief_11.entity.User;
import com.example.brief_11.mapper.UserMapper;
import com.example.brief_11.repository.RoleRepository;
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

    @Autowired
    private RoleRepository roleRepository; // Add RoleRepository

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        // Check if the role exists
        Role role = roleRepository.findByName(userRequestDTO.getRole());
        if (role == null) {
            throw new RuntimeException("Role not found: " + userRequestDTO.getRole());
        }

        User user = userMapper.userRequestDTOToUser(userRequestDTO);
        user.setRole(role); // Set the existing role to the user
        userRepository.save(user);
        return userMapper.userToUserResponseDTO(user);
    }
}
