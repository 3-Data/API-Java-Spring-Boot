package com.data.apidata.DTOs;

import java.time.LocalDate;

public record CategoryRequestDTO(
    String description,
    LocalDate createdAt,
    LocalDate updatedAt,
    LocalDate deletedAt
) {
}
