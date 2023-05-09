package com.data.apidata.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float cnpj;
    private float cep;
    private float numero;
    private float telefone;
    private float contaBancaria;
    private String razaoSocial;
    private String endereco;
    private String cidade;
    private String email;

}
