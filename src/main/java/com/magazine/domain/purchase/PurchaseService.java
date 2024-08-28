package com.magazine.domain.purchase;

import com.magazine.domain.purchase.comparators.QuantityPurchaseComparator;
import com.magazine.domain.purchase.model.GroupedPurchaseByUser;
import com.magazine.domain.purchase.model.Purchase;
import com.magazine.domain.purchase.validators.PurchaseYearValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.magazine.domain.purchase.comparators.TotalPurchaseComparator.instance;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public List<Purchase> list(final boolean ascending) {

        final List<Purchase> purchases = purchaseRepository.list();

        // Eu poderia ter utilizado algo como o SortedSet,
        // mas neste cenário, dificilmente vale a pena.
        return purchases.stream().sorted(instance(ascending)).toList();
    }

    public Purchase biggestPurchaseOfTheYear(final Integer year) {
        PurchaseYearValidator.validate(year);

        final List<Purchase> purchases = purchaseRepository.list();

        final boolean ascending = false;

        return purchases
                .stream()
                .filter(purchase -> year.equals(purchase.getProduct().getYearBuy()))
                .min(instance(ascending))
                .orElse(null);
    }

    public List<Purchase> loyalCustomers(final Integer maxCustomers) {
        final List<GroupedPurchaseByUser> purchases = purchaseRepository.listGroupedByCustomer();

        final List<GroupedPurchaseByUser> sortedByQuantityPurchases = purchases
                .stream()
                .sorted(new QuantityPurchaseComparator().reversed())
                .limit(maxCustomers)
                .toList();

        sortedByQuantityPurchases.forEach(purchase ->
            purchase.setPurchases(sortPurchaseByTotal(purchase.getPurchases()))
        );

        return sortedByQuantityPurchases
                .stream()
                .map(purchase -> purchase.getPurchases().stream().findFirst().get()) // TODO melhorar para não acessar o .get diretamente do Optional
                .sorted(instance(false))
                .toList();
    }

    private List<Purchase> sortPurchaseByTotal(final List<Purchase> purchases) {
        return purchases.stream().sorted(instance(false)).toList();
    }

    public List<Purchase> listCustomerPurchases(final String document) {

        return purchaseRepository.listCustomerPurchases(document);
    }
}
