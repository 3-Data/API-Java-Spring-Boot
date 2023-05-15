package com.data.apidata.DTOs;

public record ProductRequestDTO(
    Long idSupplier,
    String name,
    String description,
    Float productValue,
    Float length,
    Float width,
    Float longitude,
    String color
) {
}
