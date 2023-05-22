package com.data.apidata.controller;

import com.data.apidata.DTOs.ProductDTO;
import com.data.apidata.DTOs.ProductRequestDTO;
import com.data.apidata.DTOs.ProductResponseDTO;
import com.data.apidata.model.*;
import com.data.apidata.repository.CategoryRepository;
import com.data.apidata.repository.ProductImageRepository;
import com.data.apidata.repository.ProductRepository;
import com.data.apidata.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private CategoryRepository categoriesRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return repository.findAll().stream().map(ProductResponseDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{productId}")
    public ProductResponseDTO getById(@PathVariable Long productId) {
        return new ProductResponseDTO(repository.findById(productId).get());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("supplier/{supplierId}")
    public List<ProductResponseDTO> getBySupplier(@PathVariable Long supplierId) {
        return repository
                .findBySupplierId(supplierId)
                .stream().map(ProductResponseDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("category/{categoryId}")
    public List<ProductResponseDTO> getByCategory(@PathVariable Long categoryId) {
        return repository
                .findByCategoriesId(categoryId)
                .stream().map(ProductResponseDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO data) {
        Supplier supplier = supplierRepository
                                .findById(data.idSupplier())
                                .orElseThrow(() ->
                                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado!"));

        List<Category> categories = categoriesRepository
                                        .findAllByIdIn(data.categories());

        if (categories.isEmpty()) {
            throw new NoSuchElementException("Categorias não encontradas!");
        }

        List<ProductImage> productImages = data.productImages().stream()
                .map(ProductImage::new)
                .collect(Collectors.toList());

        Product product = new Product(new ProductDTO(
                supplier,
                categories,
                productImages,
                data.name(),
                data.description(),
                data.productValue(),
                data.length(),
                data.width(),
                data.longitude(),
                data.color(),
                LocalDate.now(),
                null,
                null,
                data.stock()
        ));

        productImageRepository.saveAll(productImages);
        repository.save(product);

        return new ProductResponseDTO(product);
    }

}
