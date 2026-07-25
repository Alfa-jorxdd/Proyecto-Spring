package com.alfajorxd.web.product.aplication.query.getById;

import com.alfajorxd.web.common.mediator.RequestHandler;
import com.alfajorxd.web.product.domain.entity.Product;
import com.alfajorxd.web.product.domain.exception.ProductNotFoundException;
import com.alfajorxd.web.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductGetByIdHandler implements RequestHandler<ProductGetByIdRequest, ProductGetByIdResponse> {

    private final ProductRepository productRepository;

    @Override
    public ProductGetByIdResponse handle(ProductGetByIdRequest request) {
        Product product = productRepository
                .findById(request.getId()).orElseThrow(() -> new ProductNotFoundException(request.getId()));
        return new ProductGetByIdResponse(product);
    }

    @Override
    public Class<ProductGetByIdRequest> getRequestType() {
        return ProductGetByIdRequest.class;
    }
}

