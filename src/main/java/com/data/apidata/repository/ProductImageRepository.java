package com.data.apidata.repository;

import com.data.apidata.model.Category;
import com.data.apidata.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
