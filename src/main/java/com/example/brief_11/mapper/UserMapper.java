package com.example.brief_11.mapper;

import com.example.brief_11.dto.request.UserRequestDTO;
import com.example.brief_11.dto.response.UserResponseDTO;
import com.example.brief_11.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "role", target = "role.name")
    User userRequestDTOToUser(UserRequestDTO userRequestDTO);

    @Mapping(source = "role.name", target = "role")
    UserResponseDTO userToUserResponseDTO(User user);
}

