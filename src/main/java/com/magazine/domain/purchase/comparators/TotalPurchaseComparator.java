package com.magazine.domain.purchase.comparators;

import com.magazine.domain.purchase.model.Purchase;

import java.math.BigDecimal;
import java.util.Comparator;

public class TotalPurchaseComparator implements Comparator<Purchase> {

    @Override
    public int compare(final Purchase o1, final Purchase o2) {
        final BigDecimal total1 = o1.totalPurchase();
        final BigDecimal total2 = o2.totalPurchase();

        return total1.compareTo(total2);
    }

    public static Comparator<Purchase> instance(final boolean ascending) {

        if (ascending) {
            return new TotalPurchaseComparator();
        }

        return new TotalPurchaseComparator().reversed();
    }
}
