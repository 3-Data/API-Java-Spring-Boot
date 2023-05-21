package com.data.apidata.controller;

import com.data.apidata.DTOs.SupplierRequestDTO;
import com.data.apidata.model.Supplier;
import com.data.apidata.repository.SupplierRepository;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class SupplierController {

    SupplierRepository repository;

    @GetMapping("/suppliers")
    public List<Supplier>getAllSuppliers(){
        return repository.findAll();
    }
    
    @GetMapping("/suppliers/{id}")
    public Supplier getSupplierById(@PathVariable Long id){
        return repository.findById(id).get();
    }
    @PostMapping("/suppliers")
    public Supplier saveSupplier(@RequestBody SupplierRequestDTO supplierData){
        Supplier supplier = new Supplier(supplierData);

        return repository.save(supplier);
    }

    @DeleteMapping("/suppliers/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        repository.deleteById(id);
    }
}