package com.magazine.resources.httpclient.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {

    @JsonProperty("codigo")
    private Long code;

    @JsonProperty("tipo_vinho")
    private String typeWine;

    @JsonProperty("preco")
    private BigDecimal price;

    @JsonProperty("safra")
    private String harvest;

    @JsonProperty("ano_compra")
    private Integer yearBuy;
}
