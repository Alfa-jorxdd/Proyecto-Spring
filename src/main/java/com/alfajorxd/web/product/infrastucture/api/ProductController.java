package com.alfajorxd.web.product.infrastucture.api;

import com.alfajorxd.web.common.mediator.Mediator;
import com.alfajorxd.web.product.aplication.command.create.ProductCreateRequest;
import com.alfajorxd.web.product.aplication.command.delete.ProductDeleteRequest;
import com.alfajorxd.web.product.aplication.command.update.ProductUpdateRequest;
import com.alfajorxd.web.product.aplication.query.getAll.ProductGetAllResponse;
import com.alfajorxd.web.product.aplication.query.getAll.ProductGetAlllRequest;
import com.alfajorxd.web.product.aplication.query.getById.ProductGetByIdRequest;
import com.alfajorxd.web.product.aplication.query.getById.ProductGetByIdResponse;
import com.alfajorxd.web.product.infrastucture.api.dto.CreateProductDTO;
import com.alfajorxd.web.product.infrastucture.api.dto.ProductDTO;
import com.alfajorxd.web.product.infrastucture.api.dto.UpdateProductDTO;
import com.alfajorxd.web.product.infrastucture.api.mapper.ProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final Mediator mediator;
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam(required = false) String pageSize){
        ProductGetAllResponse response = mediator.dispatch(new ProductGetAlllRequest());
        List<ProductDTO> productsDto = response.getProduct().stream().map(productMapper::mapToProductDto).toList();
        return ResponseEntity.ok(productsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        ProductGetByIdResponse response = mediator.dispatch(new ProductGetByIdRequest(id));

        ProductDTO productDto = productMapper.mapToProductDto(response.getProduct());

        return ResponseEntity.ok(productDto);
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@ModelAttribute @Valid CreateProductDTO productDto){
        ProductCreateRequest request = productMapper.mapToProductCreateRequest(productDto);

        mediator.dispatch(request);

        return ResponseEntity.created(URI.create("/api/v1/products/".concat(productDto.getId().toString()))).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct(@ModelAttribute @Valid UpdateProductDTO product){
        ProductUpdateRequest request = productMapper.mapToProductUpdateRequest(product);
        mediator.dispatch(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        mediator.dispatch(new ProductDeleteRequest(id));
        return ResponseEntity.noContent().build();
    }

}
