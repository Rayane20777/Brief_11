package com.example.brief_11.repository;

import com.example.brief_11.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Page<Product> findByNameContaining(String name, Pageable pageable);
    Page<Product> findByCategoryId(UUID categoryId, Pageable pageable);
}
