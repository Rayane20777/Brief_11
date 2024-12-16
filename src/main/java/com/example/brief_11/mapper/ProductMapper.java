package com.example.brief_11.mapper;

import com.example.brief_11.dto.request.ProductRequestDTO;
import com.example.brief_11.dto.response.ProductResponseDTO;
import com.example.brief_11.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "category.id", source = "categoryId")
    Product toEntity(ProductRequestDTO dto);

    @Mapping(target = "categoryName", source = "category.name")
    ProductResponseDTO toDto(Product entity);
}