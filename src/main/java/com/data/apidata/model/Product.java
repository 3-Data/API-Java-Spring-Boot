package com.data.apidata.model;

import com.data.apidata.DTOs.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "productValue")
    private Float productValue;

    @Column(name = "length")
    private Float length;

    @Column(name = "width")
    private Float width;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "color")
    private String color;

    @Column(name = "createdAt")
    private LocalDate createdAt;

    @Column(name = "updatedAt")
    private LocalDate updatedAt;

    @Column(name = "deletedAt")
    private LocalDate deletedAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idSupplier", nullable = false)
    private Supplier supplier;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "categoriesProduct",
        joinColumns = @JoinColumn(name = "idProduct"),
        inverseJoinColumns = @JoinColumn(name = "idCategory")
    )
    private List<Category> categories = new ArrayList<Category>();

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    private Integer stock;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Sale> sales = new ArrayList<>();

    public Product (ProductDTO data) {
        this.supplier = data.supplier();
        this.name = data.name();
        this.description = data.description();
        this.productValue = data.productValue();
        this.length = data.length();
        this.width = data.width();
        this.longitude = data.longitude();
        this.color = data.color();
        this.categories = data.categories();
        this.stock = data.stock();
        this.productImages = data.productImages();
        this.createdAt = java.time.LocalDate.now();
        this.updatedAt = null;
        this.deletedAt = null;
    }
}
