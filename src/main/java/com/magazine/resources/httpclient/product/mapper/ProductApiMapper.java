package com.magazine.resources.httpclient.product.mapper;

import com.magazine.domain.product.model.Product;
import com.magazine.resources.httpclient.product.dto.ProductDto;

public class ProductApiMapper {

    public static Product toDomain(final ProductDto productDto) {
        return Product
                .builder()
                .code(productDto.getCode())
                .typeWine(productDto.getTypeWine())
                .price(productDto.getPrice())
                .harvest(productDto.getHarvest())
                .yearBuy(productDto.getYearBuy())
                .build();
    }
}
