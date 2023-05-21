package com.data.apidata.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity(name = "productImages")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;

    @ManyToOne
    @JoinColumn(name = "idProduct", nullable = false)
    private Product product;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;
}