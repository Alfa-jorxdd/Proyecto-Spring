package com.alfajorxd.web.product.aplication.command.delete;

import com.alfajorxd.web.common.mediator.RequestHandler;
import com.alfajorxd.web.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDeleteHandler implements RequestHandler<ProductDeleteRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(ProductDeleteRequest request) {
        productRepository.deteleById(request.getId());
        return null;
    }

    @Override
    public Class<ProductDeleteRequest> getRequestType() {
        return ProductDeleteRequest.class;
    }
}

