package com.data.apidata.controller;

import com.data.apidata.DTOs.ProductResponseDTO;
import com.data.apidata.DTOs.SaleDTO;
import com.data.apidata.DTOs.SaleRequestDTO;
import com.data.apidata.DTOs.SaleResponseDTO;
import com.data.apidata.model.*;
import com.data.apidata.repository.SaleRepository;
import com.data.apidata.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sales")
public class SaleController {
    @Autowired
    private SaleRepository repository;
    @Autowired
    private BaseService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<SaleResponseDTO> getAll() {
        return repository.findAll().stream().map(SaleResponseDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{saleId}")
    public SaleResponseDTO getById(@PathVariable Long saleId) {
        return new SaleResponseDTO(repository.findById(saleId).get());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("supplier/{idSupplier}")
    public List<SaleResponseDTO> getBySupplier(@PathVariable Long idSupplier) {
        return repository
                .findBySupplierId(idSupplier)
                .stream().map(SaleResponseDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("client/{idClient}")
    public List<SaleResponseDTO> getByClient(@PathVariable Long idClient) {
        return repository
                .findByClientId(idClient)
                .stream().map(SaleResponseDTO::new).toList();
    }

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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/pay/{idSale}")
    public SaleResponseDTO paySale (@PathVariable Long idSale) {
        Optional<Sale> saleToPay = repository.findById(idSale);

        if(!saleToPay.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada!");
        }
        Sale sale = saleToPay.get();
        sale.setPayed(true);

        repository.save(sale);

        return new SaleResponseDTO(sale);
    }
}
