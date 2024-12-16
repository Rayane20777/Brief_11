package com.example.brief_11.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductRequestDTO {
    @NotNull
    private String name;

    @NotNull
    @Positive
    private Double price;

    @NotNull
    @Positive
    private Integer quantity;

    @NotNull
    private UUID categoryId;
}

