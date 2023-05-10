package com.data.apidata.model;

import com.data.apidata.DTOs.CategoryRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity(name = "category")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    public Category (CategoryRequestDTO data) {
        this.description = data.description();
        this.createdAt = java.time.LocalDate.now();
        this.updatedAt = null;
        this.deletedAt = null;
    }
}
