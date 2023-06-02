package com.data.apidata.services;

import com.data.apidata.model.*;

import java.util.List;

public interface BaseService {
    public abstract Supplier findSupplierById(Long idSupplier);
    public abstract Customer findCustomerById(Long idCustomer);
    public abstract Product findProductById(Long idProduct);
    public abstract List<Category> findCategoriesByIdsList (List<Long> categories);
    public abstract Product saveProduct(Product product);
    public abstract List<ProductImage> constructProductImagesObject(List<String> productImages);
    public abstract List<ProductImage> saveProductImages(List<ProductImage> productImages);
}
