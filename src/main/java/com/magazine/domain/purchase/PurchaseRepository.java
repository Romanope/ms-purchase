package com.magazine.domain.purchase;

import com.magazine.domain.purchase.model.GroupedPurchaseByUser;
import com.magazine.domain.purchase.model.Purchase;

import java.util.List;

public interface PurchaseRepository {

    List<Purchase> list();

    List<GroupedPurchaseByUser> listGroupedByCustomer();

    List<Purchase> listCustomerPurchases(String document);
}
