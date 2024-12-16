package com.example.brief_11.service.inpl;

import com.example.brief_11.dto.request.ProductRequestDTO;
import com.example.brief_11.dto.response.ProductResponseDTO;
import com.example.brief_11.entity.Product;
import com.example.brief_11.mapper.ProductMapper;
import com.example.brief_11.repository.ProductRepository;
import com.example.brief_11.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Page<ProductResponseDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(productMapper::toDto);
    }

    @Override
    public Page<ProductResponseDTO> searchProducts(String name, Pageable pageable) {
        return productRepository.findByNameContaining(name, pageable).map(productMapper::toDto);
    }

    @Override
    public Page<ProductResponseDTO> getProductsByCategory(UUID categoryId, Pageable pageable) {
        return productRepository.findByCategoryId(categoryId, pageable).map(productMapper::toDto);
    }

    @Override
    @Transactional
    public ProductResponseDTO createProduct(ProductRequestDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    @Transactional
    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Product updatedProduct = productMapper.toEntity(productDTO);
        updatedProduct.setId(existingProduct.getId());
        return productMapper.toDto(productRepository.save(updatedProduct));
    }

    @Override
    @Transactional
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}


