package com.magazine.resources.repository.product;

import com.magazine.domain.product.model.Product;
import com.magazine.domain.product.ProductRepository;
import com.magazine.resources.httpclient.product.ProductApiClient;
import com.magazine.resources.httpclient.product.dto.ProductDto;
import com.magazine.resources.httpclient.product.mapper.ProductApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductApiRepository  implements ProductRepository {

    private final ProductApiClient productApiClient;

    @Override
    public List<Product> list() {

        final List<ProductDto> productsDto = productApiClient.list();

        return productsDto.stream().map(ProductApiMapper::toDomain).toList();
    }
}
