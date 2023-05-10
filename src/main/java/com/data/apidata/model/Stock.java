package com.data.apidata.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity(name = "stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSupplier", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    private Supplier supplier;

    private Integer quantity;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;
}
