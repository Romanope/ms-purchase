package com.magazine.domain.purchase.comparators;

import com.magazine.domain.purchase.model.GroupedPurchaseByUser;

import java.util.Comparator;

public class QuantityPurchaseComparator implements Comparator<GroupedPurchaseByUser> {

    @Override
    public int compare(final GroupedPurchaseByUser o1, final GroupedPurchaseByUser o2) {
        final Integer totalPurchases1 = o1.getPurchases().size();
        final Integer totalPurchases2 = o2.getPurchases().size();

        return totalPurchases1.compareTo(totalPurchases2);
    }
}
