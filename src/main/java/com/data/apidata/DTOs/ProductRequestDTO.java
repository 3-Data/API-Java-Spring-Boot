package com.data.apidata.DTOs;

public record ProductRequestDTO(
    Long idSupplier,
    String name,
    String description,
    Float value,
    Float length,
    Float width,
    Float longitude,
    String color
) {
}
