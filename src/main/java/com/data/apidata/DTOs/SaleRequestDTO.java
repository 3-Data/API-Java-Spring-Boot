package com.data.apidata.DTOs;

import com.data.apidata.model.ProductInSaleRequest;

import java.util.List;

public record SaleRequestDTO(
        Long idSupplier,
        Long idCustomer,
        List<ProductInSaleRequest> products,
        Float value
) {
}
