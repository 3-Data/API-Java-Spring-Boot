package com.data.apidata.DTOs;

import java.util.List;

public record ProductRequestDTO(
    Long idSupplier,
    String name,
    String description,
    Float productValue,
    Float length,
    Float width,
    Float longitude,
    String color,
    List<Long> categories,
    List<String> productImages,
    Integer stock
) {
}
