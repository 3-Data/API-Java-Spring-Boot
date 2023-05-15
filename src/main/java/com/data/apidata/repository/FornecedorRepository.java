package com.data.apidata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.apidata.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    
}