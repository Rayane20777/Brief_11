package com.example.brief_11.service;

import com.example.brief_11.dto.request.ProductRequestDTO;
import com.example.brief_11.dto.response.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {
    Page<ProductResponseDTO> getAllProducts(Pageable pageable);
    Page<ProductResponseDTO> searchProducts(String name, Pageable pageable);
    Page<ProductResponseDTO> getProductsByCategory(UUID categoryId, Pageable pageable);
    ProductResponseDTO createProduct(ProductRequestDTO productDTO);
    ProductResponseDTO updateProduct(UUID id, ProductRequestDTO productDTO);
    void deleteProduct(UUID id);
}
