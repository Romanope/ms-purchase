package com.magazine.application.purchase.mapper;

import com.magazine.application.purchase.dto.ProductDto;
import com.magazine.domain.product.model.Product;

public class ProductMapper {

    public static ProductDto toDto(final Product product) {
        return ProductDto
                .builder()
                .code(product.getCode())
                .typeWine(product.getTypeWine())
                .harvest(product.getHarvest())
                .price(product.getPrice())
                .yearBuy(product.getYearBuy())
                .build();
    }
}
