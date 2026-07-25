package com.alfajorxd.web.product.aplication.query.getAll;

import com.alfajorxd.web.common.mediator.RequestHandler;
import com.alfajorxd.web.product.aplication.query.getById.ProductGetByIdRequest;
import com.alfajorxd.web.product.aplication.query.getById.ProductGetByIdResponse;
import com.alfajorxd.web.product.domain.Product;
import com.alfajorxd.web.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductGetAllHandler implements RequestHandler<ProductGetAlllRequest, ProductGetAllResponse> {

    private final ProductRepository productRepository;

    @Override
    public ProductGetAllResponse handle(ProductGetAlllRequest request) {
        List<Product> products = productRepository
                .findAll();
        return new ProductGetAllResponse(products);
    }

    @Override
    public Class<ProductGetAlllRequest> getRequestType() {
        return ProductGetAlllRequest.class;
    }
}

