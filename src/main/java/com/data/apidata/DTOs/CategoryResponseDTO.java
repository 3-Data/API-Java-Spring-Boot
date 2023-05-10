package com.data.apidata.DTOs;

import com.data.apidata.model.Category;

import java.time.LocalDate;

public record CategoryResponseDTO(
        Long id,
        String description,
        LocalDate createdAt,
        LocalDate updatedAt,
        LocalDate deletedAt
) {
    public CategoryResponseDTO (Category category) {
        this(
            category.getId(),
            category.getDescription(),
            category.getCreatedAt(),
            category.getUpdatedAt(),
            category.getDeletedAt()
        );
    }
}
