package com.data.apidata.services;

import com.data.apidata.model.*;
import com.data.apidata.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoriesRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Override
    public Supplier findSupplierById(Long idSupplier) {
        return supplierRepository
                .findById(idSupplier)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado!"));
    }

    @Override
    public Customer findCustomerById (Long idcustomer) {
        return customerRepository
                .findById(idcustomer)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    @Override
    public Product findProductById (Long idProduct) {
        return productRepository
                .findById(idProduct)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
    }
    @Override
    public Product saveProduct (Product product) {
        return productRepository.save(product);
    }
    @Override
    public List<Category> findCategoriesByIdsList (List<Long> categories) {
        return categoriesRepository
                .findAllByIdIn(categories);
    }
    @Override
    public List<ProductImage> constructProductImagesObject (List<String> productImages) {
        return productImages.stream()
                .map(ProductImage::new)
                .collect(Collectors.toList());
    }
    @Override
    public List<ProductImage> saveProductImages(List<ProductImage> productImages) {
        return productImageRepository.saveAll(productImages);
    }
}
