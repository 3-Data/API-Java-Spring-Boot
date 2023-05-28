package com.data.apidata.controller;

import com.data.apidata.DTOs.ProductDTO;
import com.data.apidata.DTOs.ProductRequestDTO;
import com.data.apidata.DTOs.ProductResponseDTO;
import com.data.apidata.model.*;
import com.data.apidata.repository.ProductRepository;
import com.data.apidata.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO data) {
        Supplier supplier = productService.findSupplierById(data.idSupplier());

        List<Category> categories = productService.findCategoriesByIdsList(data.categories());

        if (categories.isEmpty()) {
            throw new NoSuchElementException("Categorias não encontradas!");
        }

        List<ProductImage> productImages = productService.constructProductImagesObject(data.productImages());

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

        productService.saveProductImages(productImages);
        repository.save(product);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO(product);

        return productResponseDTO;
    }

    @PutMapping("/{idProduct}")
    public ProductResponseDTO updateProduct(@RequestBody ProductRequestDTO data, @PathVariable Long idProduct) {
        Supplier supplier = productService.findSupplierById(data.idSupplier());

        List<Category> categories = productService.findCategoriesByIdsList(data.categories());

        List<ProductImage> productImages = productService.constructProductImagesObject(data.productImages());

        Optional<Product> updatedProduct = repository.findById(idProduct);

        if(!updatedProduct.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }

        Product product = updatedProduct.get();
        product.setSupplier(supplier);
        product.setCategories(categories);
        product.setName(data.name());
        product.setDescription(data.description());
        product.setProductValue(data.productValue());
        product.setLength(data.length());
        product.setWidth(data.width());
        product.setLongitude(data.longitude());
        product.setColor(data.color());
        product.setProductImages(productImages);
        product.setStock(data.stock());
        product.setUpdatedAt(LocalDate.now());

        productService.saveProductImages(productImages);
        repository.save(product);

        return new ProductResponseDTO(product);
    }
}
