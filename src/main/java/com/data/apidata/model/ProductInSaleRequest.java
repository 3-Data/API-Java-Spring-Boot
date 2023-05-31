package com.data.apidata.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInSaleRequest {
    private Long id;
    private Integer quantity;
}
