package com.data.apidata.controller;

import org.springframework.web.bind.annotation.*;
import com.data.apidata.model.Fornecedor;
import com.data.apidata.repository.FornecedorRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class FornecedorController {

    FornecedorRepository repository;

    @GetMapping("/fornecedor")
    public List<Fornecedor>getAllFornecedor(){
        return repository.findAll();
    }
    
    @GetMapping("/fornecedor/{id}")
    public Fornecedor getFornecedorById(@PathVariable Long id){
        return repository.findById(id).get();
    }
    @PostMapping("/fornecedor")
    public Fornecedor saveFornecedor(@RequestBody Fornecedor fornecedor){
        return repository.save(fornecedor);
    }

    @DeleteMapping("/fornecedor/{id}")
    public void deleteFornecedor(@PathVariable Long id) {
        repository.deleteById(id);
    }
}