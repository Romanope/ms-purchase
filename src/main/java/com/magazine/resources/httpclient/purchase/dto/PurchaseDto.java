package com.magazine.resources.httpclient.purchase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseDto {

    @JsonProperty("codigo")
    private Long code;

    @JsonProperty("quantidade")
    private BigDecimal quantity;
}
