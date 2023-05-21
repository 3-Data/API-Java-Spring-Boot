package com.data.apidata.controller;

import com.data.apidata.DTOs.ProductDTO;
import com.data.apidata.DTOs.ProductRequestDTO;
import com.data.apidata.model.*;
import com.data.apidata.repository.CategoryRepository;
import com.data.apidata.repository.ProductImageRepository;
import com.data.apidata.repository.ProductRepository;
import com.data.apidata.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @PostMapping
    public void createProduct(@RequestBody ProductRequestDTO data) {
        Supplier supplier = supplierRepository.findById(data.idSupplier()).get();

        List<Category> categories = new ArrayList<Category>();
        if (data.categories().size() > 0) {
            categories = categoriesRepository.findAllByIdIn(data.categories());
        }

        List<ProductImage> productImages = new ArrayList<ProductImage>();
        if (data.productImages().size() > 0) {
            for(String currentImageUrl : data.productImages()) {
                ProductImage currentImage = new ProductImage(currentImageUrl);
                productImages.add(currentImage);
            }
        }

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
                java.time.LocalDate.now(),
                null,null,
                data.stock()
        ));

        productImageRepository.saveAll(productImages);
        repository.save(product);
    }
}
