package com.magazine.domain.product;

import com.magazine.domain.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toMap;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Optional<Product> findByCode(final Long code) {

        final Map<Long, Product> products = productRepository
                .list()
                .stream()
                .collect(toMap(Product::getCode, item -> item));

        return Optional.ofNullable(products.get(code));
    }

    public List<Product> findByType(String typeWine) {

        return productRepository
                .list()
                .stream()
                .filter(product -> product.getTypeWine().equals(typeWine))
                .toList();
    }
}
