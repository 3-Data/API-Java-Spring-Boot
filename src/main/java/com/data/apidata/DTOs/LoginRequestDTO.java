package com.data.apidata.DTOs;

import java.time.LocalDate;

public record LoginRequestDTO(
    String email,
    String password,
    String document,
    Character userType,
    LocalDate createdAt,
    LocalDate updatedAt,
    LocalDate deletedAt
) {
}
