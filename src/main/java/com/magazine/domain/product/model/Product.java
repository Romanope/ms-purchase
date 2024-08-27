package com.magazine.domain.product.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {

    private Long code;

    private String typeWine; // TODO revisar se é necessário criar enum

    private BigDecimal price;

    private String harvest;

    private Integer yearBuy;
}
