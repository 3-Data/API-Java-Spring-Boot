package com.data.apidata.DTOs;

import com.data.apidata.model.Category;
import com.data.apidata.model.ProductImage;
import com.data.apidata.model.Supplier;

import java.time.LocalDate;
import java.util.List;

public record ProductDTO (
        Supplier supplier,
        List<Category> categories,
        List<ProductImage> productImages,
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
        Integer stock
){
}
