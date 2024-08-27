package com.magazine.application.purchase.mapper;

import com.magazine.application.common.mapper.ProductMapper;
import com.magazine.application.purchase.dto.PurchaseDto;
import com.magazine.domain.purchase.model.Purchase;

public class PurchaseMapper {

    public static PurchaseDto toDto(final Purchase purchase) {
        if (purchase == null) {
            return null;
        }

        return PurchaseDto
                .builder()
                .personName(purchase.getPersonName())
                .document(purchase.getDocument())
                .product(ProductMapper.toDto(purchase.getProduct()))
                .quantity(purchase.getQuantity())
                .total(purchase.totalPurchase())
                .build();
    }
}
