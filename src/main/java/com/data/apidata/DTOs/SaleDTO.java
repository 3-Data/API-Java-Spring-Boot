package com.data.apidata.DTOs;

import com.data.apidata.model.Customer;
import com.data.apidata.model.Product;
import com.data.apidata.model.Supplier;

import java.util.List;

public record SaleDTO(
    Supplier supplier,
    Customer customer,
    List<Product> products,
    Float value
) {
}
