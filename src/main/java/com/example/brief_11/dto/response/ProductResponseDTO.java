package com.example.brief_11.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductResponseDTO {
    private UUID id;
    private String name;
    private Double price;
    private Integer quantity;
    private String categoryName;
}


