package com.alfajorxd.web.product.infrastucture.api.mapper;

import com.alfajorxd.web.product.aplication.command.create.ProductCreateRequest;
import com.alfajorxd.web.product.aplication.command.update.ProductUpdateRequest;
import com.alfajorxd.web.product.domain.Product;
import com.alfajorxd.web.product.infrastucture.api.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    ProductCreateRequest mapToProductCreateRequest(ProductDTO productDTO);
    ProductUpdateRequest mapToProductUpdateRequest(ProductDTO productDTO);
    ProductDTO mapToProductDto(Product product);

}
