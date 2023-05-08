package com.data.apidata.controller;

import com.data.apidata.DTOs.ProductRequestDTO;
import com.data.apidata.model.Product;
import com.data.apidata.model.Supplier;
import com.data.apidata.repository.ProductRepository;
import com.data.apidata.repository.SupplierRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository repository;
    private SupplierRepository supplierRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createProduct(@RequestBody ProductRequestDTO data) {
        Supplier supplier = supplierRepository.findById(data.idSupplier());

        Product product = new Product(data);
        product.setSupplier(supplier);

        repository.save(product);
    }
}
