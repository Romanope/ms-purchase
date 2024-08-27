package com.magazine.domain.product;

import com.magazine.domain.product.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> list();
}
