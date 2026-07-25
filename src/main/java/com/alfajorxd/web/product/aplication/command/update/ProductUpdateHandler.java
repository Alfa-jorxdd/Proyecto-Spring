package com.alfajorxd.web.product.aplication.command.update;

import com.alfajorxd.web.common.mediator.RequestHandler;
import com.alfajorxd.web.product.domain.entity.Product;
import com.alfajorxd.web.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUpdateHandler implements RequestHandler<ProductUpdateRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(ProductUpdateRequest request) {
        Product product = Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(request.getImage())
                .build();

        productRepository.save(product);
        return null;
    }

    @Override
    public Class<ProductUpdateRequest> getRequestType() {
        return ProductUpdateRequest.class;
    }
}

