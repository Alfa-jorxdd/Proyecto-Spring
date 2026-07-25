package com.alfajorxd.web.product.domain.port;

import com.alfajorxd.web.product.domain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    void deteleById(Long id);
}
