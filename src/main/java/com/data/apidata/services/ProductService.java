package com.data.apidata.services;

import com.data.apidata.model.Category;
import com.data.apidata.model.ProductImage;
import com.data.apidata.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    public abstract Supplier findSupplierById(Long idSupplier);
    public abstract List<Category> findCategoriesByIdsList (List<Long> categories);
    public abstract List<ProductImage> constructProductImagesObject(List<String> productImages);
    public abstract List<ProductImage> saveProductImages(List<ProductImage> productImages);
}
