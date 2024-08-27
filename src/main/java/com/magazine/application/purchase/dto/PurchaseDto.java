package com.magazine.application.purchase.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PurchaseDto {

    private String personName;

    private String document;

    private ProductDto product;

    private BigDecimal quantity;

    private BigDecimal total;
}
