package com.data.apidata.services.product;

import com.data.apidata.model.ProductImage;
import com.data.apidata.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductImageRepository productImageRepository;
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
