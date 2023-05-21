package com.data.apidata.DTOs;

import com.data.apidata.model.Category;
import com.data.apidata.model.Product;
import com.data.apidata.model.ProductImage;
import com.data.apidata.model.Supplier;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.List;

@JsonSerialize
public record ProductResponseDTO(
        Long id,
        Supplier supplier,
        String name,
        String description,
        Float productValue,
        Float length,
        Float width,
        Float longitude,
        String color,
        LocalDate createdAt,
        LocalDate updatedAt,
        LocalDate deletedAt,
        List<ProductImage> productImages,
        List<Category> categories,
        Integer stock
) {
    public ProductResponseDTO(Product product) {
        this(
                product.getId(),
                product.getSupplier(),
                product.getName(),
                product.getDescription(),
                product.getProductValue(),
                product.getLength(),
                product.getWidth(),
                product.getLongitude(),
                product.getColor(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getDeletedAt(),
                product.getProductImages(),
                product.getCategories(),
                product.getStock()
        );
    }
}
