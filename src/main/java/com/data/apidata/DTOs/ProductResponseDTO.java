package com.data.apidata.DTOs;

import com.data.apidata.model.Product;
import com.data.apidata.model.Supplier;

import java.time.LocalDate;

public record ProductResponseDTO(
    Long id,
    Supplier supplier,
    String name,
    String description,
    Float value,
    Float length,
    Float width,
    Float longitude,
    String color,
    LocalDate createdAt,
    LocalDate updatedAt,
    LocalDate deletedAt
) {
    public ProductResponseDTO (Product product) {
        this(
            product.getId(),
            product.getSupplier(),
            product.getName(),
            product.getDescription(),
            product.getValue(),
            product.getLength(),
            product.getWidth(),
            product.getLongitude(),
            product.getColor(),
            product.getCreatedAt(),
            product.getUpdatedAt(),
            product.getDeletedAt()
        );
    }
}
