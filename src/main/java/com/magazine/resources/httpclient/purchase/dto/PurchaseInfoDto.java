package com.magazine.resources.httpclient.purchase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseInfoDto {

    @JsonProperty("nome")
    private String personName;

    @JsonProperty("cpf")
    private String personDocument;

    @JsonProperty("compras")
    private List<PurchaseDto> purchases;
}
