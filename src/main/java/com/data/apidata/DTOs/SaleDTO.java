package com.data.apidata.DTOs;

import com.data.apidata.model.Cliente;
import com.data.apidata.model.Product;
import com.data.apidata.model.Supplier;

import java.util.List;

public record SaleDTO(
    Supplier supplier,
    Cliente client,
    List<Product> products,
    Float value
) {
}
