package com.data.apidata.DTOs;

import com.data.apidata.model.Login;

import java.time.LocalDate;
import java.util.Date;

public record LoginResponseDTO(
        Long id,
        String email,
        String password,
        String document,
        Character userType,
        LocalDate createdAt,
        LocalDate updatedAt,
        LocalDate deletedAt
) {
    public LoginResponseDTO (Login login) {
        this(
            login.getId(),
            login.getEmail(),
            login.getPassword(),
            login.getDocument(),
            login.getUserType(),
            login.getCreatedAt(),
            login.getUpdatedAt(),
            login.getDeletedAt()
        );
    }
}
