package com.data.apidata.model;

import com.data.apidata.DTOs.SaleDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "sale")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sale {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idSupplier", nullable = false)
    private Supplier supplier;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idClient", nullable = false)
    private Cliente client;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "saleProducts",
            joinColumns = @JoinColumn(name = "idSale"),
            inverseJoinColumns = @JoinColumn(name = "idProduct")
    )
    private List<Product> products;

    @Column(name = "saleValue")
    private Float saleValue;

    @Column(name = "payed")
    private Boolean payed = false;

    @Column(name = "createdAt")
    private LocalDate createdAt;

    @Column(name = "updatedAt")
    private LocalDate updatedAt;

    @Column(name = "deletedAt")
    private LocalDate deletedAt;

    public Sale (SaleDTO data) {
        this.supplier = data.supplier();
        this.client = data.client();
        this.products = data.products();
        this.saleValue = data.value();
        this.payed = false;
        this.createdAt = LocalDate.now();
    }
}
