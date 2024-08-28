package com.magazine.resources.repository.purchase;

import com.magazine.domain.customer.exceptions.CustomerResourceNotFoundException;
import com.magazine.domain.purchase.PurchaseRepository;
import com.magazine.domain.purchase.model.GroupedPurchaseByUser;
import com.magazine.domain.purchase.model.Purchase;
import com.magazine.resources.httpclient.purchase.PurchaseApiClient;
import com.magazine.resources.httpclient.purchase.dto.PurchaseInfoDto;
import com.magazine.resources.httpclient.purchase.mapper.PurchaseApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PurchaseApiRepository implements PurchaseRepository {

    private final PurchaseApiClient client;

    private final PurchaseApiMapper mapper;

    @Override
    public List<Purchase> list() {

        final List<PurchaseInfoDto> purchaseData = client.list();

        return mapper.toPurchase(purchaseData);
    }

    @Override
    public List<GroupedPurchaseByUser> listGroupedByCustomer() {

        final List<PurchaseInfoDto> purchaseData = client.list();

        return mapper.toGroupedPurchaseByUser(purchaseData);
    }

    @Override
    public List<Purchase> listCustomerPurchases(final String document) {
        final PurchaseInfoDto purchaseData = client
                .list()
                .stream()
                .filter(item -> item.getPersonDocument().equals(document))
                .findFirst()
                .orElseThrow(() -> new CustomerResourceNotFoundException("The customer has no purchases"));

        return mapper.toPurchase(purchaseData);
    }
}
