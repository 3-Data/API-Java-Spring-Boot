package com.data.apidata.model;

import com.data.apidata.DTOs.SupplierRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "supplier")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String document;
    private String socialReason;
    private String commercialReason;
    private String email;
    private String logo;
    private Float rating;
    private Boolean premium;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    public Supplier(SupplierRequestDTO data) {
        this.document = data.document();
        this.socialReason = data.socialReason();
        this.commercialReason = data.commercialReason();
        this.email = data.email();
        this.logo = data.logo();
        this.rating = 5.00F;
        this.premium = false;
        this.createdAt = java.time.LocalDate.now();
        this.updatedAt = null;
        this.deletedAt = null;
    }
}
