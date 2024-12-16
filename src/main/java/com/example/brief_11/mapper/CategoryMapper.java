package com.example.brief_11.mapper;

import com.example.brief_11.dto.request.CategoryRequestDTO;
import com.example.brief_11.dto.response.CategoryResponseDTO;
import com.example.brief_11.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryRequestDTO dto);
    CategoryResponseDTO toDto(Category entity);
}
