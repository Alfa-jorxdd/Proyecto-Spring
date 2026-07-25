package com.alfajorxd.web.product.aplication.query.getById;

import com.alfajorxd.web.product.domain.Product;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductGetByIdResponse {
    private Product product;
}
