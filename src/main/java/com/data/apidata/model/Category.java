package com.data.apidata.model;

import com.data.apidata.DTOs.CategoryRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category (CategoryRequestDTO data) {
        this.description = data.description();
        this.createdAt = java.time.LocalDate.now();
        this.updatedAt = null;
        this.deletedAt = null;
    }
}
