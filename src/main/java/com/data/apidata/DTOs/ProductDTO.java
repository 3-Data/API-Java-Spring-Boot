package com.data.apidata.DTOs;

import com.data.apidata.model.Supplier;

import java.time.LocalDate;

public record ProductDTO (
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
){
}
