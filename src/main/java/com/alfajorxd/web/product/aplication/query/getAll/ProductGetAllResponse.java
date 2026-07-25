package com.alfajorxd.web.product.aplication.query.getAll;

import com.alfajorxd.web.product.domain.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ProductGetAllResponse {
    private List<Product> product;
}
