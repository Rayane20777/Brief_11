package com.example.brief_11.mapper;

import com.example.brief_11.dto.response.RoleResponseDTO;
import com.example.brief_11.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleResponseDTO roleToRoleResponseDTO(Role role);
}
