package com.data.apidata.controller;

import com.data.apidata.DTOs.ProductDTO;
import com.data.apidata.DTOs.ProductRequestDTO;
import com.data.apidata.model.Product;
import com.data.apidata.model.Supplier;
import com.data.apidata.repository.ProductRepository;
import com.data.apidata.repository.SupplierRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository repository;
    private SupplierRepository supplierRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createProduct(@RequestBody ProductRequestDTO data) {
        Supplier supplier = supplierRepository.findById(data.idSupplier()).get();

        Product product = new Product(new ProductDTO(
                supplier,
                data.name(),
                data.description(),
                data.productValue(),
                data.length(),
                data.width(),
                data.longitude(),
                data.color(),
                java.time.LocalDate.now(),
                null,null
        ));
        repository.save(product);
    }
}
