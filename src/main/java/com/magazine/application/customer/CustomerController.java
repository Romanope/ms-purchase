package com.magazine.application.customer;

import com.magazine.application.common.dto.ListRequestResult;
import com.magazine.application.common.dto.ProductDto;
import com.magazine.application.common.mapper.ProductMapper;
import com.magazine.application.purchase.dto.PurchaseDto;
import com.magazine.application.purchase.mapper.PurchaseMapper;
import com.magazine.domain.customer.CustomerService;
import com.magazine.domain.product.model.Product;
import com.magazine.domain.purchase.PurchaseService;
import com.magazine.domain.purchase.model.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final PurchaseService purchaseService;

    @GetMapping("/{document}/product/recommendation")
    public ResponseEntity<ProductDto> recommendation(@PathVariable("document") final String document) {

        final Product product = customerService.recommendationToCostumer(document);

        final ProductDto productDto = ProductMapper.toDto(product);

        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/{document}/purchases")
    public ResponseEntity<ListRequestResult<PurchaseDto>> loyalCustomers(@PathVariable("document") final String document) {
        // TODO necessário validar o parâmetro Document. Poderia ser feito com spring bean
        //  validation. Tenho preferência por criar validadores customizados dentro do core business,
        //  dessa forma é reusável, e mais facilmente testavel com os unitários. Além disso,
        //  trata-se de uma regra de negócio, então é justo que esteja na camada de core business.

        final List<Purchase> purchases = purchaseService.listCustomerPurchases(document);

        final List<PurchaseDto> result = purchases.stream().map(PurchaseMapper::toDto).toList();

        return ResponseEntity.ok(new ListRequestResult<>(result));
    }
}
