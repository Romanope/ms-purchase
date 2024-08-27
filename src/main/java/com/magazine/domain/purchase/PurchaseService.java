package com.magazine.domain.purchase;

import com.magazine.domain.purchase.model.Purchase;
import com.magazine.domain.purchase.validators.PurchaseYearValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.magazine.domain.purchase.comparators.FullPurchaseComparator.instance;
import static java.util.stream.Collectors.groupingBy;

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

    public List<Purchase> loyalCustomers() {
        final List<Purchase> purchases = purchaseRepository.list();

        final Map<String, List<Purchase>> purchasesByUser =
                purchases
                .stream()
                .collect(groupingBy(Purchase::getDocument));

        return null; // TODO
    }
}
