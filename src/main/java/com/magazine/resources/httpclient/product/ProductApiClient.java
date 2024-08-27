package com.magazine.resources.httpclient.product;

import com.magazine.resources.httpclient.product.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = ProductApiClient.NAME, url = "${services.product.api.url}")
public interface ProductApiClient {

    String NAME = "productClient";

    @GetMapping(value = "/produtos-mnboX5IPl6VgG390FECTKqHsD9SkLS.json")
    List<ProductDto> list();
}
