package com.data.apidata.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity(name = "productImage")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    public ProductImage (String image) {
        this.image = image;
        this.createdAt = java.time.LocalDate.now();
        this.updatedAt = null;
        this.deletedAt = null;
    }
}
