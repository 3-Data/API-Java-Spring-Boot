package com.data.apidata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (nullable = false, name = "name")
    private String name;

    @Column (name = "document")
    private String document;

    @Column (name = "telephone")
    private String telephone;

    @Column (name = "email")
    private String email;


    @Column (name = "lastPurchaseDate")
    private String lastPurchaseDate;

    @Column (name = "image")
    private String image;

    @Column (name = "socialName")
    private String socialName;

    @Column (name = "gender")
    private Enum gender;

    @Column (name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "createdAt")
    private LocalDate createdAt;

    @Column(name = "updatedAt")
    private LocalDate updatedAt;

    @Column(name = "deletedAt")
    private LocalDate deletedAt;

}
