package com.magazine.resources.httpclient.purchase;

import com.magazine.resources.httpclient.purchase.dto.PurchaseInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = PurchaseApiClient.NAME, url = "${services.purchase.api.url}")
public interface PurchaseApiClient {

    String NAME = "purchaseClient";

    @GetMapping(value = "/clientes-Vz1U6aR3GTsjb3W8BRJhcNKmA81pVh.json")
    List<PurchaseInfoDto> list();
}
