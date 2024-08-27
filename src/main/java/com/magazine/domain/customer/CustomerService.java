package com.magazine.domain.customer;

import com.magazine.domain.product.ProductService;
import com.magazine.domain.product.model.Product;
import com.magazine.domain.purchase.PurchaseService;
import com.magazine.domain.purchase.comparators.QuantityProductPurchaseComparator;
import com.magazine.domain.purchase.model.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CustomerService {

    public static final int TOP_THREE = 3;

    private final PurchaseService purchaseService;
    private final ProductService productService;

    public Product recommendationToCostumer(final String document) {

        final List<Purchase> purchases = purchaseService
                .listCustomerPurchases(document)
                .stream()
                .sorted(new QuantityProductPurchaseComparator().reversed())
                .limit(TOP_THREE)
                .toList();

        final Product product = select(purchases).getProduct();

        final List<Product> products = productService.findByType(product.getTypeWine());

        return select(products);
    }

    private <T> T select(final List<T> elements) {

        final int randomIndex = new Random().nextInt(elements.size());

        return elements.get(randomIndex);
    }
}
