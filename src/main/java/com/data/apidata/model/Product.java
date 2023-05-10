package com.data.apidata.model;

import com.data.apidata.DTOs.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name="idSupplier", nullable = false)
    private Supplier supplier;

    @ManyToMany(mappedBy = "products")
    Set<Category> categories;

    public Product (ProductDTO data) {
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
