package com.magazine.application.purchase;

import com.magazine.application.common.dto.ListRequestResult;
import com.magazine.application.purchase.dto.PurchaseDto;
import com.magazine.application.purchase.mapper.PurchaseMapper;
import com.magazine.domain.purchase.PurchaseService;
import com.magazine.domain.purchase.model.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Boolean.TRUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1//purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<ListRequestResult<PurchaseDto>> listPurchases() {

        final boolean sortAscending = TRUE;

        final List<Purchase> purchases = purchaseService.list(sortAscending);

        final List<PurchaseDto> result = purchases.stream().map(PurchaseMapper::toDto).toList();

        return ResponseEntity.ok(new ListRequestResult<>(result));
    }

    @GetMapping("/{year}/biggest-purchase")
    public ResponseEntity<PurchaseDto> biggestPurchaseOfTheYear(@PathVariable("year") final Integer year) {

        final Purchase purchase = purchaseService.biggestPurchaseOfTheYear(year);

        final PurchaseDto result = PurchaseMapper.toDto(purchase);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/loyal-customers")
    public ResponseEntity<ListRequestResult<PurchaseDto>> loyalCustomers(@RequestParam(value = "maxCustomers", required = false, defaultValue = "3") final Integer maxCustomers) {

        final List<Purchase> purchases = purchaseService.loyalCustomers(maxCustomers);

        final List<PurchaseDto> result = purchases.stream().map(PurchaseMapper::toDto).toList();

        return ResponseEntity.ok(new ListRequestResult<>(result));
    }
}
