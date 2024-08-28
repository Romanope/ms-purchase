package com.magazine.domain.purchase.model;

import com.magazine.domain.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Purchase {

    private String personName;

    private String document;

    private Product product;

    private BigDecimal quantity;

    public BigDecimal totalPurchase() {
        return quantity.multiply(product.getPrice());
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "personName='" + personName + '\'' +
                ", document='" + document + '\'' +
                ", product=" + product +
                ", quantity=" + quantity +
                ", total=" + totalPurchase() +
                '}';
    }
}
