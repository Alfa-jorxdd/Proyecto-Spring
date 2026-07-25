package com.alfajorxd.web.product.infrastucture.database.mapper;

import com.alfajorxd.web.product.domain.Product;
import com.alfajorxd.web.product.infrastucture.database.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductEntityMapper {

    ProductEntity mapToProductEntity(Product product);
    Product mapToProduct(ProductEntity productEntity);

}
