package com.example.brief_11.mapper;

import com.example.brief_11.dto.request.UserRequestDTO;
import com.example.brief_11.dto.response.RoleResponseDTO;
import com.example.brief_11.dto.response.UserResponseDTO;
import com.example.brief_11.entity.Role;
import com.example.brief_11.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "role", target = "role.name") // Map role from String to Role entity's name
    User userRequestDTOToUser(UserRequestDTO userRequestDTO);

    @Mapping(source = "role", target = "role", qualifiedByName = "roleToRoleResponseDTO")
    UserResponseDTO userToUserResponseDTO(User user);

    @Named("roleToRoleResponseDTO")
    default RoleResponseDTO roleToRoleResponseDTO(Role role) {
        if (role == null) return null;
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setName(role.getName());
        return roleResponseDTO;
    }
}