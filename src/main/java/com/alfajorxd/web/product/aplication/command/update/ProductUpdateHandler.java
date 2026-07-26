package com.alfajorxd.web.product.aplication.command.update;

import com.alfajorxd.web.common.mediator.RequestHandler;
import com.alfajorxd.web.common.util.FileUtils;
import com.alfajorxd.web.product.domain.entity.Product;
import com.alfajorxd.web.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class ProductUpdateHandler implements RequestHandler<ProductUpdateRequest, Void> {

    private final ProductRepository productRepository;
    private final FileUtils fileUtils;

    @Override
    public Void handle(ProductUpdateRequest request) {

        String uniqueFileName = fileUtils.saveProductImage(request.getFile());

        Product product = Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(uniqueFileName)
                .build();

        productRepository.save(product);
        return null;
    }

    @Override
    public Class<ProductUpdateRequest> getRequestType() {
        return ProductUpdateRequest.class;
    }
}

