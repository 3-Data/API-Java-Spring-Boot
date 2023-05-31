package com.data.apidata.controller;

import com.data.apidata.DTOs.SaleDTO;
import com.data.apidata.DTOs.SaleRequestDTO;
import com.data.apidata.DTOs.SaleResponseDTO;
import com.data.apidata.model.*;
import com.data.apidata.repository.SaleRepository;
import com.data.apidata.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sales")
public class SaleController {
    @Autowired
    private SaleRepository repository;
    @Autowired
    private BaseService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public SaleResponseDTO createSale(@RequestBody SaleRequestDTO data) {
        Supplier supplier = service.findSupplierById(data.idSupplier());
        Cliente client = service.findClientById(data.idClient());

        List<Product> products = new ArrayList<>();
        for (ProductInSaleRequest productData :  data.products()) {
            Product product = service.findProductById(productData.getId());
            Integer stockAmount = product.getStock() - productData.getQuantity();

            product.setStock(stockAmount > 0 ? stockAmount : 0);

            service.saveProduct(product);
            products.add(product);
        }

        Sale sale = new Sale(new SaleDTO(supplier, client, products, data.value()));
        repository.save(sale);

        return new SaleResponseDTO(sale);
    }
}
