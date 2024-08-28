package com.magazine.domain.purchase;

import com.magazine.domain.product.model.Product;
import com.magazine.domain.purchase.model.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PurchaseServiceTest {

    private PurchaseService purchaseService;

    @Mock
    private PurchaseRepository purchaseRepository;

    @BeforeEach
    void beforeEach() {
        purchaseService = new PurchaseService(purchaseRepository);
    }

    @Test
    void shouldSortPurchasesForTotalPaidInAscendingDirectionWhenAscendingIsTrue() { // TODO eu poderia usar testes parametrizados (@ParameterizedTest do Junit. Normalmente utilizo quando há mais de dois cenário semelhantes.
        when(purchaseRepository.list()).thenReturn(mockedPurchases());

        final boolean ascending = true;
        final List<Purchase> result = purchaseService.list(ascending);

        final List<Purchase> expectedResult = mockedPurchasesSortAscending();
        assertEquals(expectedResult, result);
        verify(purchaseRepository).list();
    }

    @Test
    void shouldSortPurchasesForTotalPaidInDescendingDirectionWhenAscendingIsFalse() {
        when(purchaseRepository.list()).thenReturn(mockedPurchases());

        final boolean ascending = false;
        final List<Purchase> result = purchaseService.list(ascending);

        final List<Purchase> expectedResult = mockedPurchasesSortDescending();
        assertEquals(expectedResult, result);
        verify(purchaseRepository).list();
    }

    private List<Purchase> mockedPurchases() {
        final Product product1 = new Product(1L, "Tinto", TEN, "2018", 2019);
        final Product product2 = new Product(1L, "Tinto", valueOf(5), "2018", 2019);

        return List.of(
                new Purchase("Person 1", "12345678911", product2, valueOf(10)),
                new Purchase("Person 2", "12345678912", product1, valueOf(100)),
                new Purchase("Person 3", "12345678913", product2, valueOf(1)),
                new Purchase("Person 4", "12345678914", product1, valueOf(50))
        );
    }

    private List<Purchase> mockedPurchasesSortAscending() {
        return mockedPurchases().stream().sorted((o1, o2) -> {
            final BigDecimal total1 = o1.totalPurchase();
            final BigDecimal total2 = o2.totalPurchase();

            return total1.compareTo(total2);
        }).toList();
    }

    private List<Purchase> mockedPurchasesSortDescending() {
        return mockedPurchases().stream().sorted((o1, o2) -> {
            final BigDecimal total1 = o1.totalPurchase();
            final BigDecimal total2 = o2.totalPurchase();

            return total2.compareTo(total1);
        }).toList();
    }
}