package com.example.brief_11.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRequestDTO {
    @NotNull
    private String name;
    private String description;
}