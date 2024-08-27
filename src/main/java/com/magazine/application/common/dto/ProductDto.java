package com.magazine.application.common.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {

    private Long code;

    private String typeWine;

    private BigDecimal price;

    private String harvest;

    private Integer yearBuy;
}
