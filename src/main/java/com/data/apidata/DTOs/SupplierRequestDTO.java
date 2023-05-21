package com.data.apidata.DTOs;

import java.time.LocalDate;

public record SupplierRequestDTO(
    String document,
    String socialReason,
    String commercialReason,
    String email,
    String logo,
    Float rating,
    Boolean premium
) {
}
