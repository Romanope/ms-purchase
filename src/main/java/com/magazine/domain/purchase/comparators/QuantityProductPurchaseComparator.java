package com.magazine.domain.purchase.comparators;

import com.magazine.domain.purchase.model.Purchase;

import java.math.BigDecimal;
import java.util.Comparator;

public class QuantityProductPurchaseComparator implements Comparator<Purchase> {

    @Override
    public int compare(final Purchase o1, final Purchase o2) {
        final BigDecimal quantity1 = o1.getQuantity();
        final BigDecimal quantity2 = o2.getQuantity();

        return quantity1.compareTo(quantity2);
    }
}
