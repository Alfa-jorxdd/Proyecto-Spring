package com.alfajorxd.web.product.infrastucture.database;

import com.alfajorxd.web.product.domain.Product;
import com.alfajorxd.web.product.domain.ProductRepository;
import com.alfajorxd.web.product.infrastucture.database.entity.ProductEntity;
import com.alfajorxd.web.product.infrastucture.database.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoyImpl implements ProductRepository {

    private final List<ProductEntity> products = new ArrayList<>();

    private final ProductEntityMapper productEntityMapper;

    @Override
    public void save(Product product) {
        ProductEntity productEntity = productEntityMapper.mapToProductEntity(product);
        products.removeIf(productEntity1 -> productEntity.getId().equals(productEntity1.getId()));
        products.add(productEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .map(productEntityMapper::mapToProduct);
    }

    @Override
    public List<Product> findAll() {
        return products.stream().map(productEntityMapper::mapToProduct).toList();
    }

    @Override
    public void deteleById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
