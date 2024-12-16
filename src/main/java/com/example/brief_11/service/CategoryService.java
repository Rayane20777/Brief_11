package com.example.brief_11.service;

import com.example.brief_11.dto.request.CategoryRequestDTO;
import com.example.brief_11.dto.response.CategoryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CategoryService {
    Page<CategoryResponseDTO> getAllCategories(Pageable pageable);
    Page<CategoryResponseDTO> searchCategories(String name, Pageable pageable);
    CategoryResponseDTO createCategory(CategoryRequestDTO categoryDTO);
    CategoryResponseDTO updateCategory(UUID id, CategoryRequestDTO categoryDTO);
    void deleteCategory(UUID id);
}
