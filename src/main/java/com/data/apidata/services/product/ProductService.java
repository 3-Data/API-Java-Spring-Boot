package com.data.apidata.services.product;

import com.data.apidata.model.ProductImage;
import com.data.apidata.services.BaseService;

import java.util.List;

public interface ProductService extends BaseService {
    public abstract List<ProductImage> constructProductImagesObject(List<String> productImages);
    public abstract List<ProductImage> saveProductImages(List<ProductImage> productImages);
}
