package com.example.brief_11.service.inpl;

import com.example.brief_11.dto.request.CategoryRequestDTO;
import com.example.brief_11.dto.response.CategoryResponseDTO;
import com.example.brief_11.entity.Category;
import com.example.brief_11.mapper.CategoryMapper;
import com.example.brief_11.repository.CategoryRepository;
import com.example.brief_11.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Page<CategoryResponseDTO> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(categoryMapper::toDto);
    }

    @Override
    public Page<CategoryResponseDTO> searchCategories(String name, Pageable pageable) {
        return categoryRepository.findByNameContaining(name, pageable).map(categoryMapper::toDto);
    }

    @Override
    @Transactional
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    @Transactional
    public CategoryResponseDTO updateCategory(UUID id, CategoryRequestDTO categoryDTO) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Category updatedCategory = categoryMapper.toEntity(categoryDTO);
        updatedCategory.setId(existingCategory.getId());
        return categoryMapper.toDto(categoryRepository.save(updatedCategory));
    }

    @Override
    @Transactional
    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }
}


