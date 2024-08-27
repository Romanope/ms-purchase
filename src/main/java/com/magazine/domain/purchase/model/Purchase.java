package com.magazine.domain.purchase.model;

import com.magazine.domain.product.model.Product;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Purchase {

    private String personName;

    private String document;

    private Product product;

    private BigDecimal quantity;

    public BigDecimal totalPurchase() {
        return quantity.multiply(product.getPrice());
    }
}
