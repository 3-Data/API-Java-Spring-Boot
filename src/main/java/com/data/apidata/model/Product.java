package com.data.apidata.model;

import com.data.apidata.DTOs.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Supplier supplier;

    private String name;
    private String description;
    private Float value;
    private Float length;
    private Float width;
    private Float longitude;
    private String color;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    public Product (ProductRequestDTO data) {
        this.supplier = data.supplier();
        this.name = data.name();
        this.description = data.description();
        this.value = data.value();
        this.length = data.length();
        this.width = data.width();
        this.longitude = data.longitude();
        this.color = data.color();
        this.createdAt = java.time.LocalDate.now();
        this.updatedAt = null;
        this.deletedAt = null;
    }
}
