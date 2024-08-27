package com.magazine.resources.httpclient.purchase.mapper;

import com.magazine.domain.product.ProductService;
import com.magazine.domain.product.model.Product;
import com.magazine.domain.purchase.model.Purchase;
import com.magazine.resources.httpclient.purchase.dto.PurchaseDto;
import com.magazine.resources.httpclient.purchase.dto.PurchaseInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PurchaseApiMapper {

    private final ProductService productService;

    public List<Purchase> toDomain(final List<PurchaseInfoDto> purchasesDto) {

        final List<Purchase> purchases = new ArrayList<>();

        for (PurchaseInfoDto purchaseInfo: purchasesDto) {
            purchases.addAll(toFullPurchases(purchaseInfo));
        }

        return purchases;
    }

    private List<Purchase> toFullPurchases(final PurchaseInfoDto purchaseInfo) {

        return purchaseInfo
                .getPurchases()
                .stream()
                .map(purchase -> toFullPurchase(purchaseInfo, purchase))
                .toList();
    }

    private Purchase toFullPurchase(final PurchaseInfoDto purchaseInfo, final PurchaseDto purchase) {
        final Product product = productService.findByCode(purchase.getCode()).orElseThrow();// TODO Criar exceção customizada

        return Purchase
                .builder()
                .personName(purchaseInfo.getPersonName())
                .document(purchaseInfo.getPersonDocument())
                .product(product)
                .quantity(purchase.getQuantity())
                .build();
    }
}
