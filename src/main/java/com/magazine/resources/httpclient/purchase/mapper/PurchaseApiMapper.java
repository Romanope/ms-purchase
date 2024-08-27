package com.magazine.resources.httpclient.purchase.mapper;

import com.magazine.domain.product.ProductService;
import com.magazine.domain.product.model.Product;
import com.magazine.domain.purchase.model.GroupedPurchaseByUser;
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

    public List<GroupedPurchaseByUser> toGroupedPurchaseByUser(final List<PurchaseInfoDto> purchasesDto) {

        final List<GroupedPurchaseByUser> purchases = new ArrayList<>();

        for (PurchaseInfoDto purchaseInfo: purchasesDto) {
            purchases.add(GroupedPurchaseByUser
                    .builder()
                    .personName(purchaseInfo.getPersonName())
                    .document(purchaseInfo.getPersonDocument())
                    .purchases(toPurchases(purchaseInfo))
                    .build());
        }

        return purchases;
    }

    public List<Purchase> toPurchase(final List<PurchaseInfoDto> purchasesDto) {

        final List<Purchase> purchases = new ArrayList<>();

        for (PurchaseInfoDto purchaseInfo: purchasesDto) {
            purchases.addAll(toPurchases(purchaseInfo));
        }

        return purchases;
    }

    private List<Purchase> toPurchases(final PurchaseInfoDto purchaseInfo) {

        return purchaseInfo
                .getPurchases()
                .stream()
                .map(purchase -> toPurchase(purchaseInfo, purchase))
                .toList();
    }

    private Purchase toPurchase(final PurchaseInfoDto purchaseInfo, final PurchaseDto purchase) {
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
