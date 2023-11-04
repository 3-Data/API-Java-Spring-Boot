package com.data.apidata.model;

import com.data.apidata.DTOs.CustomerRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice.This;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "customer")
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String document;
    private String socialName;
    private String email;
    private String image;
    private String telephone;
    private String gender;
    private String birthDate;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Customer> customer;

    public Customer(CustomerRequestDTO data) {
        this.name = data.name();
        this.document = data.document();
        this.socialName = data.socialName();
        this.email = data.email();
        this.image = data.image();
        this.telephone = data.telephone();
        this.gender = data.gender();
        this.birthDate = data.birthDate();
        this.createdAt = java.time.LocalDate.now();
        this.updatedAt = null;
        this.deletedAt = null;
    }

}
