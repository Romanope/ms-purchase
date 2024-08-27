package com.magazine.domain.purchase.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GroupedPurchaseByUser {

    private String personName;

    private String document;

    private List<Purchase> purchases;
}
